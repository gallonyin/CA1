package org.caworks.ca1.test.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import org.caworks.ca1.R;
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
        setContentView(R.layout.activity_tinker_test);

        findViewById(R.id.bt_load_path).setOnClickListener(this);
        findViewById(R.id.bt_clear_path).setOnClickListener(this);
        findViewById(R.id.bt_toast).setOnClickListener(this);
        findViewById(R.id.bt_show_info).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_load_path:
                CustomToast.showToast();
                break;
            case R.id.bt_clear_path:
                break;
            case R.id.bt_toast:
                break;
            case R.id.bt_show_info:
                break;
        }
    }
}
