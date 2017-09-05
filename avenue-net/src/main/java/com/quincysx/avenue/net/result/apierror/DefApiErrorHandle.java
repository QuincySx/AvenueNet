package com.quincysx.avenue.net.result.apierror;

import com.quincysx.avenue.net.result.exception.ApiException;

/**
 * Created by wang.rongqiang on 2017/9/5.
 * 默认
 */

public final class DefApiErrorHandle implements IApiErrorHandle {
    private static final class Holder {
        private static DefApiErrorHandle Instance = new DefApiErrorHandle();
    }

    public static DefApiErrorHandle getInstance() {
        return Holder.Instance;
    }

    @Override
    public ApiException onHandle(Throwable t) {
        if (t instanceof ApiException) {
            return (ApiException) t;
        }
        return new ApiException(-1, t.getMessage());
    }
}
