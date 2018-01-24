package util;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * 非APPmodule内 判断编译版本 (debug/release)
 * Created by gallon on 2018/1/24.
 */

public class BuildConfigUtils {

    private static Boolean isDebug = null;

    public static boolean isDebug() {
        return isDebug == null ? false : isDebug.booleanValue();
    }

    /**
     * Sync lib debug with app's debug value. Should be called in module Application
     *
     * @param context
     */
    public static void syncIsDebug(Context context) {
        if (isDebug == null) {
            isDebug = context.getApplicationInfo() != null &&
                    (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        }
    }
}