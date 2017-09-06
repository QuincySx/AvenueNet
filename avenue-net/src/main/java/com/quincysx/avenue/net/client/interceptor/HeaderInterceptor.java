package com.quincysx.avenue.net.client.interceptor;

import com.quincysx.avenue.net.AvenueNet;
import com.quincysx.avenue.net.ConfigKey;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wang.rongqiang on 2017/9/6.
 * 设置通用请求头
 */

public class HeaderInterceptor implements Interceptor {
    public static HeaderInterceptor create() {
        return new HeaderInterceptor();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request request = chain.request();
        final okhttp3.Request.Builder builder = request.newBuilder();

        final HashMap<String, String> hashMap = AvenueNet.getConfig(ConfigKey.COMMON_HTTP_HEADER);
        final Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            final String key = iterator.next();
            final String value = hashMap.get(key);
            builder.addHeader(key, value);
        }

        final Request build = builder.build();
        return chain.proceed(build);
    }
}
