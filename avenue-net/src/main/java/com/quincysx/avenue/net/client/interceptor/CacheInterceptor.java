package com.quincysx.avenue.net.client.interceptor;


import com.quincysx.avenue.net.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wang.rongqiang on 2017/1/12.
 * 缓存 拦截器
 */

public class CacheInterceptor extends BaseInterceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetworkUtils.isConnected()) {
            //无网络下强制使用缓存，无论缓存是否过期,此时该请求实际上不会被发送出去。
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }

        Response response = chain.proceed(request);
        if (NetworkUtils.isConnected()) {//有网络情况下，根据请求接口的设置，配置缓存。
            //这样在下次请求时，根据缓存决定是否真正发出请求。
            String cacheControl = request.cacheControl().toString();
            //当然如果你想在有网络的情况下都直接走网络，那么只需要
            //将其超时时间这是为0即可:String cacheControl="Cache-Control:public,max-age=0"
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .addHeader("Cache-Control", "public,max-age=0")
                    .build();
        } else {//无网络
//            ToastUtils.showShortToast(R.string.api_read_cache);
            int maxStale = 60 * 60 * 24 * 7 * 2;
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .addHeader("Cache-Control", "public,only-if-cached," +
                            "max-stale=" + maxStale)
                    .build();
        }
    }
}
