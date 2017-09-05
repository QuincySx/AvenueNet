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
    public void onError(ApiException e) {
    }

    /**
     * 请求完成
     */
    public void onComplete() {
    }
}
