package com.quincysx.avenue.net.result.apiverify;
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
