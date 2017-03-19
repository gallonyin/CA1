package org.caworks.ca1.activity.module;

import android.database.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;

import org.caworks.library.activity.BaseActivity;
import org.caworks.library.util.GLog;

/**
 * Created by gallon on 17-3-19.
 */

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GLog.d();

//        Observable.just(initAppData())
//                .
    }

    private String initAppData() {

        return null;
    }
}
