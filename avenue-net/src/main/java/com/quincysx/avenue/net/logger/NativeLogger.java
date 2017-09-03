package com.quincysx.avenue.net.logger;

import android.util.Log;

/**
 * Created by quincysx on 2017/9/3.
 */

public final class NativeLogger implements Logger {
    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;
    private static final int NOTHING = 6;

    //控制log等级
    private final int LEVEL;
    private final String TAG = "AvenueNet";

    public NativeLogger() {
        LEVEL = VERBOSE;
    }

    public NativeLogger(int LEVEL) {
        this.LEVEL = LEVEL;
    }

    public void v(String tag, String message) {
        if (LEVEL <= VERBOSE) {
            Log.v(tag, message);
        }
    }

    public void d(String tag, Object message) {
        if (LEVEL <= DEBUG) {
            Log.d(tag, message.toString());
        }
    }

    public void d(Object message) {
        if (LEVEL <= DEBUG) {
            Log.d(TAG, message.toString());
        }
    }

    public void i(String tag, String message) {
        if (LEVEL <= INFO) {
            Log.i(tag, message);
        }
    }

    public void w(String tag, String message) {
        if (LEVEL <= WARN) {
            Log.w(tag, message);
        }
    }

    public void json(String tag, String message) {
        if (LEVEL <= WARN) {
            Log.i(tag, message);
        }
    }

    public void e(String tag, String message) {
        if (LEVEL <= ERROR) {
            Log.e(tag, message);
        }
    }
}
