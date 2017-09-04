package com.quincysx.avenue.net.result.exception;

/**
 * Created by quincysx on 2017/9/3.
 * Api异常时爆出此异常
 */

public class ApiException extends Exception {
    public int mCode = -1;

    public ApiException() {
    }

    public ApiException(int code, String message) {
        super(message);
        mCode = code;
    }
}
