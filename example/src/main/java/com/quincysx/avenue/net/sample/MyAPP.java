package com.quincysx.avenue.net.sample;

import android.app.Application;

import com.quincysx.avenue.net.AvenueNet;
import com.quincysx.avenue.net.client.interceptor.ApiTestInterceptor;
import com.quincysx.avenue.net.sample.api.errorhandle.ErrorHandle;
import com.quincysx.avenue.net.sample.api.logger.MyLogger;
import com.quincysx.avenue.net.sample.api.verify.ApiVerify;

/**
 * Created by wang.rongqiang on 2017/9/1.
 */

public class MyAPP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AvenueNet.init(this)
                .withApiHost("http://172.16.133.60:8080/")
//                .withApiHost("http://192.168.0.104:8080/")
                .withHttpLog(true)
                .withHttpTimeout(2000)
                .withHeader("testheader", "ceshi")
                .withLogger(new MyLogger())
                .withVerify(new ApiVerify())
                .withErrorHandle(new ErrorHandle())
                .withAPITest(false)
                .withInterceptors(new ApiTestInterceptor("index", R.raw.index))
                .build();
    }
}
