package com.quincysx.avenue.net.client;

import com.quincysx.avenue.net.AvenueNet;
import com.quincysx.avenue.net.ConfigKey;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by quincysx on 2017/8/31.
 */

public final class NetClientCreator {
    private static class RetrofitHolder {
        private static final Retrofit Instance = new Retrofit.Builder()
                .client(OkHttpHolder.Instance)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private static class OkHttpHolder {
        private static final long timeout = AvenueNet.getConfig(ConfigKey.HTTP_TIME_OUT);
        private static final OkHttpClient Instance = new OkHttpClient().newBuilder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .addInterceptor(OkHttpLoggerHolder.Instance)
                .build();
    }

    private static class OkHttpLoggerHolder {
        private static final HttpLoggingInterceptor Instance = getHttpLoggingInterceptor();
    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        final HttpLoggingInterceptor mInterceptor = new HttpLoggingInterceptor();
        final boolean logger = AvenueNet.getConfig(ConfigKey.OKHTTP_LOGGER);
        if (logger) {
            mInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            mInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return mInterceptor;
    }

    public static Retrofit getRetrofitInstance() {
        return RetrofitHolder.Instance;
    }

    public static OkHttpClient getOkHttpInstance() {
        return OkHttpHolder.Instance;
    }

    public static HttpLoggingInterceptor getHttpLoggingInstance() {
        return OkHttpLoggerHolder.Instance;
    }
}
