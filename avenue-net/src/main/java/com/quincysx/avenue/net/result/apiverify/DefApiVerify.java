package com.quincysx.avenue.net.result.apiverify;

import com.quincysx.avenue.net.result.exception.ApiException;

/**
 * Created by wang.rongqiang on 2017/9/4.
 * 统一处理异常等问题
 */

public final class DefApiVerify implements IApiVerify {
    private static final class Holder {
        private static DefApiVerify Instance = new DefApiVerify();
    }

    public static DefApiVerify getInstance() {
        return Holder.Instance;
    }

    @Override
    public synchronized <T> void verify(T t) throws ApiException {
        
    }
}
