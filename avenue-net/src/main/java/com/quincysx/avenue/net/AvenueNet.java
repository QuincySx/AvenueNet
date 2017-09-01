package com.quincysx.avenue.net;

import android.content.Context;

/**
 * Created by quincysx on 2017/8/31.
 * 网络模块主要配置入口
 */

public final class AvenueNet {

    private AvenueNet() {
    }

    /**
     * 初始化公共配置
     *
     * @param context
     * @return
     */
    public static Configurator init(Context context) {
        setConfig(ConfigKey.APP_CONTEXT, context);
        setConfig(ConfigKey.HTTP_TIME_OUT, 30);
        return Configurator.newInstance(ConfigManager.getInstance());
    }

    /**
     * 读取公共配置
     *
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T getConfig(@ConfigKey.Key String key) {
        return ConfigManager.getInstance().getConfig(key);
    }

    /**
     * 设置公共配置
     *
     * @param key
     * @param value
     */
    public static void setConfig(@ConfigKey.Key String key, Object value) {
        ConfigManager.getInstance().setConfig(key, value);
    }
}
