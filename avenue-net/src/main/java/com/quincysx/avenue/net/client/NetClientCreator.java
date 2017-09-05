package com.quincysx.avenue.net.client;
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

import android.util.Log;

import com.quincysx.avenue.net.ConfigKey;
import com.quincysx.avenue.net.logger.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.quincysx.avenue.net.AvenueNet.getConfig;

/**
 * Created by quincysx on 2017/8/31.
 * 创建网络请求相关对象
 */

final class NetClientCreator {
    private static class RetrofitHolder {
        private static final String baseurl = getConfig(ConfigKey.BASE_URL);
        private static final Retrofit Instance = new Retrofit.Builder()
                .baseUrl(baseurl)
                .client(OkHttpHolder.Instance)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private static class OkHttpHolder {
        private static final long timeout = getConfig(ConfigKey.HTTP_TIME_OUT);
        private static final OkHttpClient Instance = new OkHttpClient().newBuilder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .addInterceptor(OkHttpLoggerHolder.Instance)
                .build();
    }

    private static class OkHttpLoggerHolder {
        private static final LoggingInterceptor Instance = getHttpLoggingInterceptor();
    }

    private static LoggingInterceptor getHttpLoggingInterceptor() {
        final LoggingInterceptor mInterceptor = new LoggingInterceptor(new LoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("AvenueNet", message);
            }
        });
        final boolean logger = getConfig(ConfigKey.OKHTTP_LOGGER);
        if (logger) {
            mInterceptor.setLevel(LoggingInterceptor.Level.BODY);
        } else {
            mInterceptor.setLevel(LoggingInterceptor.Level.NONE);
        }
        return mInterceptor;
    }

    static Retrofit getRetrofitInstance() {
        return RetrofitHolder.Instance;
    }

    static OkHttpClient getOkHttpInstance() {
        return OkHttpHolder.Instance;
    }

    static LoggingInterceptor getHttpLoggingInstance() {
        return OkHttpLoggerHolder.Instance;
    }
}
