package com.quincysx.avenue.net.result;

import com.quincysx.avenue.net.result.exception.ApiException;

/**
 * Created by quincysx on 2017/9/3.
 */

public class ApiCallbackSubscriber<T> extends ApiSubscriber<T> {
    ApiCallback<T> callBack;
    T data;

    public ApiCallbackSubscriber(ApiCallback<T> callBack) {
        if (callBack == null) {
            throw new NullPointerException("this callback is null!");
        }
        this.callBack = callBack;
        callBack.onStart();
    }

    @Override
    public void onError(ApiException e) {
        callBack.onError(e);
    }

    @Override
    public void onNext(T t) {
        callBack.onSuccess(t);
    }

    @Override
    public void onComplete() {
        callBack.onComplete();
    }

    public T getData() {
        return data;
    }
}
