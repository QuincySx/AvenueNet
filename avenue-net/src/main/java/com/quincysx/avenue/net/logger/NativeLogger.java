package com.quincysx.avenue.net.logger;
/*
 * Copyright (C) 2017 QuincySx<quincysx@sina.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.support.annotation.IntDef;
import android.util.Log;

/**
 * Created by quincysx on 2017/9/3.
 */

public final class NativeLogger implements Logger {
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;

    //控制log等级
    private final int LEVEL;
    private final String TAG = "AvenueNet";

    private static NativeLogger NATIVE_LOGGER;

    @IntDef({VERBOSE, DEBUG, INFO, WARN, ERROR, NOTHING})
    public @interface Level {
    }

    private NativeLogger(int LEVEL) {
        this.LEVEL = LEVEL;
    }

    public static NativeLogger getInstance() {
        return getInstance(VERBOSE);
    }

    public static NativeLogger getInstance(@Level int i) {
        if (NATIVE_LOGGER == null) {
            synchronized (NativeLogger.class) {
                if (NATIVE_LOGGER == null) {
                    NATIVE_LOGGER = new NativeLogger(i);
                }
            }
        }
        return NATIVE_LOGGER;
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
