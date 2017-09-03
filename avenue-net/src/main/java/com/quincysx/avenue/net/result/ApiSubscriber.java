package com.quincysx.avenue.net.result;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by quincysx on 2017/9/3.
 */

public abstract class ApiSubscriber<T> extends DisposableObserver<T> {


    @Override
    public void onError(Throwable t) {
        // TODO: 2017/9/3 未作处理
        onError(new ApiException());
    }

    public abstract void onError(ApiException e);
}
