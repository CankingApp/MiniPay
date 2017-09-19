package com.canking.minipay;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * Created by changxing on 2017/9/19.
 */

public class Utils {
    /*package*/
    static void closeIO(Closeable target) {
        try {
            if (target != null)
                target.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*package*/
    static boolean isActivityAvailable(Context cxt, Intent intent) {
        PackageManager pm = cxt.getPackageManager();
        if (pm == null) {
            return false;
        }
        List<ResolveInfo> list = pm.queryIntentActivities(
                intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list != null && list.size() > 0;
    }
}
