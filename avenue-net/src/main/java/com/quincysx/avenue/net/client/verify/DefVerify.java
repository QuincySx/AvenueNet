package com.quincysx.avenue.net.client.verify;

import com.quincysx.avenue.net.result.exception.ApiException;

/**
 * Created by wang.rongqiang on 2017/9/4.
 * 统一处理异常等问题
 */

public class DefVerify implements Iverify {
    private static final class Holder {
        private static DefVerify Instance = new DefVerify();
    }

    public static DefVerify getInstance() {
        return Holder.Instance;
    }

    @Override
    public synchronized <T> void verify(T t) throws ApiException {

    }
}
