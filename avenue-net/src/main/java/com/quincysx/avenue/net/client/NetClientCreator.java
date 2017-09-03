package com.quincysx.avenue.net.client;

import com.quincysx.avenue.net.AvenueNet;
import com.quincysx.avenue.net.ConfigKey;
import com.quincysx.avenue.net.logger.Logger;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.quincysx.avenue.net.AvenueNet.getConfig;

/**
 * Created by quincysx on 2017/8/31.
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
        private static final HttpLoggingInterceptor Instance = getHttpLoggingInterceptor();
    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        final HttpLoggingInterceptor mInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                final Logger logger = AvenueNet.getConfig(ConfigKey.LOGGER_CLIENT);
                logger.i("AvenueNet", message);
            }
        });
        final boolean logger = getConfig(ConfigKey.OKHTTP_LOGGER);
        if (logger) {
            mInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            mInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return mInterceptor;
    }

    static Retrofit getRetrofitInstance() {
        return RetrofitHolder.Instance;
    }

    static OkHttpClient getOkHttpInstance() {
        return OkHttpHolder.Instance;
    }

    static HttpLoggingInterceptor getHttpLoggingInstance() {
        return OkHttpLoggerHolder.Instance;
    }
}
