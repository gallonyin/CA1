package org.caworks.ca1.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 项目中所有activity的基类
 * Created by gallon on 2017/3/14
 */

public class BaseActivity extends AppCompatActivity {

    protected Context mContext = this;
    protected Activity mActivity = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
