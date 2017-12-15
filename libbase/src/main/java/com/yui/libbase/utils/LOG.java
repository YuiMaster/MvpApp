package com.yui.libbase.utils;

import android.util.Log;

/**
 * Log辅助类
 *
 * @author Jane
 * @date 2017/11/27
 */

public class LOG {
    private static final String TAG = "ydb/";

    public static int w(String data) {
        return Log.w(TAG, data);
    }

    public static int w(String tag, String data) {
        return Log.w(TAG + tag, data);
    }

    public static int e(String data) {
        return Log.e(TAG, data);
    }

    public static int e(String tag, String data) {
        return Log.e(TAG + tag, data);
    }

    public static int i(String data) {
        return Log.i(TAG, data);
    }

    public static int i(String tag, String data) {
        return Log.i(TAG + tag, data);
    }
}
