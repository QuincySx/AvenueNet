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
