package com.quincysx.avenue.net.logger;

/**
 * Created by quincysx on 2017/9/3.
 */

public interface Logger {
    void v(String tag, String message);

    void d(String tag, Object message);

    void d(Object message);

    void i(String tag, String message);

    void w(String tag, String message);

    void json(String tag, String message);

    void e(String tag, String message);
}
