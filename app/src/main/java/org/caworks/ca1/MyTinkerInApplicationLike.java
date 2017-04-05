package org.caworks.ca1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

import org.caworks.library.util.GLog;

/**
 * Created by gallon on 2017/3/15
 */

@DefaultLifeCycle(
        application = ".TinkerInApplication",             //application name to generate
        flags = ShareConstants.TINKER_ENABLE_ALL)                                //tinkerFlags above
public class MyTinkerInApplicationLike extends DefaultApplicationLike {
    public MyTinkerInApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    // 相当于 Application 的 onCreate 方法
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);

        MultiDex.install(base);
        //初始化Tinker
        TinkerInstaller.install(this);
        //获得全局上下文
        application = base;
    }

    private static Context application;

    public static Context getInstance() {
        return application;
    }
}
