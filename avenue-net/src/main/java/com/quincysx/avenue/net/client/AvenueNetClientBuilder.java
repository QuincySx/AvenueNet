package com.quincysx.avenue.net.client;

import android.content.Context;

import com.quincysx.avenue.net.ConfigKey;
import com.quincysx.avenue.net.Configurator;

/**
 * Created by quincysx on 2017/8/31.
 */

public class AvenueNetClientBuilder {

    AvenueNetClientBuilder() {
    }

    AvenueNetClientBuilder(Context context) {
        Configurator.getInstance().setConfig(ConfigKey.APP_CONTEXT, context);
    }

    public AvenueNetClientBuilder setAppContext(Context context) {
        Configurator.getInstance().setConfig(ConfigKey.APP_CONTEXT, context);
        return this;
    }


}
