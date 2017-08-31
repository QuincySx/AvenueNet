package com.quincysx.avenue.net.client;

import android.content.Context;

/**
 * Created by quincysx on 2017/8/31.
 */

public class AvenueNetClient {

    public static AvenueNetClientBuilder Builder(Context context) {
        return new AvenueNetClientBuilder(context);
    }

    public static AvenueNetClientBuilder Builder() {
        return new AvenueNetClientBuilder();
    }

    public static ClientService getService() {
        return AvenueNetClientCreator.getRetrofitInstance().create(ClientService.class);
    }

    public static <T> T createService(Class aClass) {
        return (T) AvenueNetClientCreator.getRetrofitInstance().create(aClass);
    }
}
