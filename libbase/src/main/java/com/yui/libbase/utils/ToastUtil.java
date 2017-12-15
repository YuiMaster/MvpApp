package com.yui.libbase.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Jane on 2017/11/22.
 */

public class ToastUtil {
    public static void show(Context context, String data) {
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context, String data) {
        Toast.makeText(context, data, Toast.LENGTH_LONG).show();
    }
}
