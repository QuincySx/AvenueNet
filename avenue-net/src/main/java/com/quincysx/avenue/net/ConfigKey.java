package com.quincysx.avenue.net;
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

import android.support.annotation.StringDef;

/**
 * Created by quincysx on 2017/8/31.
 */

public final class ConfigKey {

    static final String CONFIG_READY = "config_ready";
    static final String LOGGER_CLIENT = "logger_client";
    static final String VERIFY_CLIENT = "verify_client";
    static final String ERROR_HANDLE = "error_handle";

    public static final String APP_CONTEXT = "app_context";
    public static final String BASE_URL = "base_url";
    public static final String OKHTTP_LOGGER = "okhttp_logger";
    public static final String HTTP_TIME_OUT = "http_time_out";
    public static final String COMMON_HTTP_HEADER = "common_http_header";
    public static final String APITEST = "api_test";
    public static final String COMMON_INTERCEPTORS = "common_interceptors";
    public static final String COMMON_CACHE = "common_cache";

    @StringDef({APP_CONTEXT, BASE_URL, OKHTTP_LOGGER, CONFIG_READY, HTTP_TIME_OUT, LOGGER_CLIENT, VERIFY_CLIENT, ERROR_HANDLE, COMMON_HTTP_HEADER, APITEST, COMMON_INTERCEPTORS, COMMON_CACHE})
    public @interface Key {
    }
}
