package com.quincysx.avenue.net.result.apierror;
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
