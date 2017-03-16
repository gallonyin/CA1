package org.caworks.ca1.test.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import org.caworks.ca1.R;
import org.caworks.ca1.test.service.MyAccessibilityService;
import org.caworks.ca1.ui.activity.BaseActivity;
import org.caworks.library.util.CustomToast;

/**
 * Created by gallon on 2017/3/16
 */

public class TestWxAttentionActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "TestWxAttentionActivity";

    public static void enterActivity(Context context) {
        Intent intent = new Intent(context, TestWxAttentionActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_test);

        findViewById(R.id.bt_start_service).setOnClickListener(this);
        findViewById(R.id.bt_clear_path).setOnClickListener(this);
        findViewById(R.id.bt_toast).setOnClickListener(this);
        findViewById(R.id.bt_show_info).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_start_service:
                if (!isAccessibilitySettingsOn(this)) {
                    CustomToast.showToast(mContext, "没打开");
                    Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                    startActivity(intent);
                    return;
                }
                    CustomToast.showToast(mContext, "已经打开");
                startService(new Intent(this, MyAccessibilityService.class));
                break;
            case R.id.bt_clear_path:
                break;
            case R.id.bt_toast:
                break;
            case R.id.bt_show_info:
                break;
        }
    }

    public boolean isAccessibilitySettingsOn(Context mContext) {
        int accessibilityEnabled = 0;
        final String service = getPackageName() + "/" + MyAccessibilityService.class.getCanonicalName();  //这里改成自己的class
        try {
            accessibilityEnabled = Settings.Secure.getInt(mContext.getApplicationContext().getContentResolver(),
                    Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException ignored) {
        }
        TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');
        if (accessibilityEnabled == 1) {
            String settingValue = Settings.Secure.getString(mContext.getApplicationContext().getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (settingValue != null) {
                mStringColonSplitter.setString(settingValue);
                while (mStringColonSplitter.hasNext()) {
                    String accessibilityService = mStringColonSplitter.next();
                    if (accessibilityService.equalsIgnoreCase(service)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
