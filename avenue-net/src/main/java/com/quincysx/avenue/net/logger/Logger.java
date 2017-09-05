package com.quincysx.avenue.net.logger;
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
 */

public interface Logger {
    void v(String tag, String message);

    void d(String tag, Object message);

    void d(Object message);

    void i(String tag, String message);

    void w(String tag, String message);

    void json(String tag, String message);

    void e(String tag, String message);
}
