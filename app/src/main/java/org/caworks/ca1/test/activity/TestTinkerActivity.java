package org.caworks.ca1.test.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

import org.caworks.ca1.R;
import org.caworks.ca1.ui.activity.BaseActivity;

import java.io.File;

/**
 * Created by gallon on 2017/3/15
 */

public class TestTinkerActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "TestTinkerActivity";

    public static void enterActivity(Context context) {
        Intent intent = new Intent(context, TestTinkerActivity.class);
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
                String path = Environment.getExternalStorageDirectory() + File.separator + "patch_signed_7zip.apk";
                File file = new File(path);
                if (file.exists()) {
                    Toast.makeText(this, "补丁存在", Toast.LENGTH_SHORT).show();
                    TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);
                } else {
                    Toast.makeText(this, "补丁不存在", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_clear_path:
                Tinker.with(getApplicationContext()).cleanPatch();
                String path1 = Environment.getExternalStorageDirectory() + File.separator + "patch_signed_7zip.apk";
                File file1 = new File(path1);
                if (file1.exists()) {
                    file1.delete();
                    Toast.makeText(this, "补丁已删除", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "补丁不存在", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_toast:
                Toast.makeText(this, "修改后的内容", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_show_info:

                break;
        }
    }
}
