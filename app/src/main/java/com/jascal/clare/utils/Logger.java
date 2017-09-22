package com.jascal.clare.utils;

import android.util.Log;

import com.jascal.clare.Constant;

/**
 * @author No.47 create at 2017/9/5.
 */
public class Logger {

    public static void v(String tag, String msg) {
        Log.v(tag, msg);
    }

    public static void d(String tag, String msg) {
        Log.d(tag, msg);
    }
}
