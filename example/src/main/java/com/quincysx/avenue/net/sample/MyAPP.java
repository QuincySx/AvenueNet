package com.quincysx.avenue.net.sample;

import android.app.Application;

import com.quincysx.avenue.net.AvenueNet;

/**
 * Created by wang.rongqiang on 2017/9/1.
 */

public class MyAPP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AvenueNet.init(this)
                .withHttpLog(true)
                .withHttpTimeout(2000)
                .build();
    }
}
