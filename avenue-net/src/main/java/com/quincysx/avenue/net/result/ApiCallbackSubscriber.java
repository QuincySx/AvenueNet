package com.quincysx.avenue.net.result;
/*
 * Copyright (C) 2017 QuincySx<quincysx@sina.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.quincysx.avenue.net.result.exception.ApiException;

/**
 * Created by quincysx on 2017/9/3.
 * 处理回调
 */

public final class ApiCallbackSubscriber<T> extends ApiSubscriber<T> {
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
