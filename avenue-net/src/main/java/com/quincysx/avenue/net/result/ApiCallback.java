package com.quincysx.avenue.net.result;

/**
 * Created by quincysx on 2017/9/3.
 */

public abstract class ApiCallback<T> {
    /**
     * 网络请求开始
     */
    public void onStart() {
    }

    /**
     * 请求成功
     *
     * @param data
     */
    public abstract void onSuccess(T data);

    /**
     * 请求失败
     *
     * @param e
     */
    public void onError(Throwable e) {
    }

    /**
     * 请求完成
     */
    public void onComplete() {
    }
}
