package com.quincysx.avenue.net.result;

import com.quincysx.avenue.net.AvenueNet;
import com.quincysx.avenue.net.result.exception.ApiException;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by quincysx on 2017/9/3.
 */

public abstract class ApiSubscriber<T> extends DisposableObserver<T> {
    @Override
    public void onError(Throwable t) {
        // TODO: 2017/9/3 未作处理
        if (t instanceof ApiException) {
            onError((ApiException) t);
        } else {
            onError(new ApiException());
        }
        AvenueNet.getLogger().e("ApiError", t.toString());
    }

    public abstract void onError(ApiException e);
}
