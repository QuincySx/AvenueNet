package com.quincysx.avenue.net.sample.logger;


import android.support.annotation.IntDef;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by quincysx on 2017/9/3.
 */

public final class MyLogger implements com.quincysx.avenue.net.logger.Logger {
    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;
    private static final int NOTHING = 6;

    //控制log等级
    private final int LEVEL;
    
    private static MyLogger sMyLogger;

    @IntDef({VERBOSE, DEBUG, INFO, WARN, ERROR, NOTHING})
    public @interface Level {
    }

    private MyLogger(@Level int i) {
        LEVEL = i;
        if (LEVEL != NOTHING) {
            Logger.addLogAdapter(new AndroidLogAdapter());
        }
        if (LEVEL == ERROR) {
            Logger.addLogAdapter(new DiskLogAdapter());
        }
    }

    public static MyLogger getInstance() {
        return getInstance(VERBOSE);
    }

    public static MyLogger getInstance(@Level int i) {
        if (sMyLogger == null) {
            synchronized (MyLogger.class) {
                if (sMyLogger == null) {
                    sMyLogger = new MyLogger(i);
                }
            }
        }
        return sMyLogger;
    }

    public void v(String tag, String message) {
        if (LEVEL <= VERBOSE) {
            Logger.t(tag).v(message);
        }
    }

    public void d(String tag, Object message) {
        if (LEVEL <= DEBUG) {
            Logger.t(tag).d(message);
        }
    }

    public void d(Object message) {
        if (LEVEL <= DEBUG) {
            Logger.d(message);
        }
    }

    public void i(String tag, String message) {
        if (LEVEL <= INFO) {
            Logger.t(tag).i(message);
        }
    }

    public void w(String tag, String message) {
        if (LEVEL <= WARN) {
            Logger.t(tag).w(message);
        }
    }

    public void json(String tag, String message) {
        if (LEVEL <= WARN) {
            Logger.t(tag).json(message);
        }
    }

    public void e(String tag, String message) {
        if (LEVEL <= ERROR) {
            Logger.t(tag).e(message);
        }
    }
}
