package org.caworks.ca1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.caworks.ca1.test.activity.TestMainActivity;
import org.caworks.library.activity.BaseActivity;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestMainActivity.enterActivity(mContext);
            }
        });
    }

    /**
     * 在回退后 仍不关闭 进程进入后台
     */
    @Override
    public void onBackPressed() {
        Intent launcherIntent = new Intent(Intent.ACTION_MAIN);
        launcherIntent.addCategory(Intent.CATEGORY_HOME);
        startActivity(launcherIntent);
    }

}
