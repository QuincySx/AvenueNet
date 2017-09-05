package com.quincysx.avenue.net.result;

import com.quincysx.avenue.net.ConfigManager;
import com.quincysx.avenue.net.result.exception.ApiException;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by quincysx on 2017/9/3.
 */

public abstract class ApiSubscriber<T> extends DisposableObserver<T> {
    @Override
    public void onError(Throwable t) {
        onError(ConfigManager.getApiErrorHandle().onHandle(t));
        ConfigManager.getLogger().e("ApiError", t.toString());
    }

    public void onError(ApiException e) {
    }
}
