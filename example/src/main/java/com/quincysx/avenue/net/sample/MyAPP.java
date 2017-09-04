package com.quincysx.avenue.net.sample;

import android.app.Application;

import com.quincysx.avenue.net.AvenueNet;
import com.quincysx.avenue.net.sample.logger.MyLogger;

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
                .withLogger(MyLogger.getInstance())
                .build();
    }
}
