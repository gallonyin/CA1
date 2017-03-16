package org.caworks.ca1.test.service;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

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
        }
        Log.i(TAG, eventText);
        Log.i(TAG, "=============END=====================");
    }

    @Override
    public void onInterrupt() {
        // TODO Auto-generated method stub
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
        return super.onStartCommand(intent, flags, startId);
    }

}
