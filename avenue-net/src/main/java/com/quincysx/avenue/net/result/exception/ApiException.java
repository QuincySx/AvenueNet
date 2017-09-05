package com.quincysx.avenue.net.result.exception;
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

/**
 * Created by quincysx on 2017/9/3.
 * Api异常时爆出此异常
 */

public class ApiException extends Exception {
    public int mCode = -1;

    public ApiException() {
    }

    public ApiException(int code, String message) {
        super(message);
        mCode = code;
    }
}
