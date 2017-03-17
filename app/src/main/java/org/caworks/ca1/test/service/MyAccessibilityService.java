package org.caworks.ca1.test.service;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import org.caworks.library.util.CustomToast;
import org.caworks.library.util.GLog;

import java.util.List;

/**
 * Test WX plug-in
 * Created by gallon on 2017/3/16
 */

public class MyAccessibilityService extends AccessibilityService {
    private static final String TAG = "MyAccessibilityService";

    @SuppressLint("NewApi")
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        int eventType = event.getEventType();
        String eventText = "";
        Log.i(TAG, "==============Start====================");
        switch (eventType) {
//            case AccessibilityEvent.TYPE_VIEW_CLICKED:
//                eventText = "TYPE_VIEW_CLICKED";
//                break;
            case AccessibilityEvent.TYPE_VIEW_LONG_CLICKED:
                CustomToast.showToast(getApplicationContext(), "长点击改变");
                eventText = "TYPE_VIEW_LONG_CLICKED";
                break;
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                CustomToast.showToast(getApplicationContext(), "窗口改变");
                eventText = "TYPE_WINDOW_STATE_CHANGED";
                break;
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                CustomToast.showToast(getApplicationContext(), "通知改变");
                eventText = "TYPE_NOTIFICATION_STATE_CHANGED";
                break;
            case AccessibilityEvent.CONTENT_CHANGE_TYPE_SUBTREE:
                AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
                List<AccessibilityNodeInfo> wxList = nodeInfo.findAccessibilityNodeInfosByText("1日旧");
                GLog.e("点击了");
                for (AccessibilityNodeInfo accessibilityNodeInfo : wxList) {
//                    accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
                    GLog.e("点击了2");
                    accessibilityNodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                    break;
                }
                CustomToast.showToast(getApplicationContext(), "内容改变");
                eventText = "CONTENT_CHANGE_TYPE_SUBTREE";
                break;
            //每次在聊天界面中有新消息到来时都出触发该事件
            case AccessibilityEvent.TYPE_VIEW_SCROLLED:
                //获取当前聊天页面的根布局
                AccessibilityNodeInfo rootNode = getRootInActiveWindow();
                //获取聊天信息
                getWeChatLog(rootNode);
                break;
        }
        Log.i(TAG, eventText);
        Log.i(TAG, "=============END=====================");
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
        return super.onStartCommand(intent, flags, startId);
    }




    /**
     * 聊天对象
     */
    private String ChatName;
    /**
     * 聊天最新一条记录
     */
    private String ChatRecord = "test";

    /**
     * 遍历
     *
     * @param rootNode
     */

    /**
     * Note: level > SDK 4.3 (18)
     * @param rootNode
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void getWeChatLog(AccessibilityNodeInfo rootNode) {
        if (rootNode != null) {
            //获取所有聊天的线性布局
            List<AccessibilityNodeInfo> listChatRecord = rootNode.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/o");
            if(listChatRecord.size()==0){
                return;
            }
            //获取最后一行聊天的线性布局（即是最新的那条消息）
            AccessibilityNodeInfo finalNode = listChatRecord.get(listChatRecord.size() - 1);
            //获取聊天对象list（其实只有size为1）
            List<AccessibilityNodeInfo> imageName = finalNode.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/i_");
            //获取聊天信息list（其实只有size为1）
            List<AccessibilityNodeInfo> record = finalNode.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/ib");
            if (imageName.size() != 0) {
                if (record.size() == 0) {
                    //判断当前这条消息是不是和上一条一样，防止重复
                    if (!ChatRecord.equals("对方发的是图片或者表情")) {
                        //获取聊天对象
                        ChatName = imageName.get(0).getContentDescription().toString().replace("头像", "");
                        //获取聊天信息
                        ChatRecord = "对方发的是图片或者表情";

                        Log.e("AAAA", ChatName + "：" + "对方发的是图片或者表情");
                        Toast.makeText(this, ChatName + "：" + ChatRecord, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //判断当前这条消息是不是和上一条一样，防止重复
                    if (!ChatRecord.equals(record.get(0).getText().toString())) {
                        //获取聊天对象
                        ChatName = imageName.get(0).getContentDescription().toString().replace("头像", "");
                        //获取聊天信息
                        ChatRecord = record.get(0).getText().toString();

                        Log.e("AAAA", ChatName + "：" + ChatRecord);
                        Toast.makeText(this, ChatName + "：" + ChatRecord, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    /**
     * 必须重写的方法：系统要中断此service返回的响应时会调用。在整个生命周期会被调用多次。
     */
    @Override
    public void onInterrupt() {
        CustomToast.showToast(this, "我快被终结了啊-----");
    }

    /**
     * 服务开始连接
     */
    @Override
    protected void onServiceConnected() {
        Toast.makeText(this, "服务已开启", Toast.LENGTH_SHORT).show();
        super.onServiceConnected();
    }

    /**
     * 服务断开
     *
     * @param intent
     * @return
     */
    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "服务已被关闭", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }
}
