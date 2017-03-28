package org.caworks.ca1.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.caworks.ca1.model.preference.PreferenceHelper;
import org.caworks.library.activity.BaseActivity;
import org.caworks.library.util.GLog;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by gallon on 17-3-19.
 */

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GLog.d();

        Observable.just(initAppData())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        gotoMainPage();
                    }
                });
    }

    private void gotoMainPage() {
        MainActivity.enterActivity(mContext);
        finish();
    }

    private String initAppData() {
        PreferenceHelper.loadDefaults();
        return "";
    }
}
