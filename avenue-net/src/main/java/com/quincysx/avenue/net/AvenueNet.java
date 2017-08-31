package com.quincysx.avenue.net;

import android.content.Context;

/**
 * Created by quincysx on 2017/8/31.
 * 网络模块主要配置入口
 */

public class AvenueNet {

    private AvenueNet() {
    }

    public static Configurator init(Context context) {
        setConfig(ConfigKey.APP_CONTEXT, context);
        return Configurator.getInstance();
    }

    public static <T> T getConfig(@ConfigKey.Key String key) {
        return Configurator.getInstance().getConfig(key);
    }

    public static void setConfig(@ConfigKey.Key String key, Object value) {
        Configurator.getInstance().setConfig(key, value);
    }
}
