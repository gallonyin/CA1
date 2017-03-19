package org.caworks.ca1.activity.module;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.caworks.ca1.model.preference.PreferenceHelper;
import org.caworks.library.activity.BaseActivity;
import org.caworks.library.util.GLog;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


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
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
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
