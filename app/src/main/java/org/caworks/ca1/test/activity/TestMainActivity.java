package org.caworks.ca1.test.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import org.caworks.ca1.R;
import org.caworks.ca1.ui.activity.BaseActivity;

/**
 * Created by gallon on 2017/3/14
 */

public class TestMainActivity extends BaseActivity {

    public static void enterActivity(Context context) {
        Intent intent = new Intent(context, TestMainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        findViewById(R.id.bt_tinker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestTinkerActivity.enterActivity(mContext);
            }
        });
    }
}
