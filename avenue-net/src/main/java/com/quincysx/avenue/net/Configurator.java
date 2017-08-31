package com.quincysx.avenue.net;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by quincysx on 2017/8/31.
 * 公共配置项存储
 */

public final class Configurator {
    private final Map<String, Object> ConfigMap = new HashMap<>();

    private static class Holder {
        private static Configurator Instance = new Configurator();
    }

    public static Configurator getInstance() {
        return Holder.Instance;
    }

    public Configurator() {
        ConfigMap.put(ConfigKey.CONFIG_READY, false);
        ConfigMap.put(ConfigKey.OKHTTP_LOGGER, false);
    }

    public final void setConfig(@ConfigKey.Key String key, Object value) {
        ConfigMap.put(key, value);
    }

    public final <T> T getConfig(@ConfigKey.Key String key) {
        if (ConfigMap.get(ConfigKey.CONFIG_READY) == false) {
            throw new RuntimeException("is NetWork Not Ready");
        }
        final Object value = ConfigMap.get(key);
        if (value == null) {
            throw new NullPointerException(key + " IS NULL");
        }
        return (T) value;
    }

    /*
    Builder 模式配置项
    */

    /**
     * 配置公共主机名
     *
     * @param host
     * @return
     */
    public final Configurator withHost(@NonNull String host) {
        ConfigMap.put(ConfigKey.BASE_URL, host);
        return this;
    }

    /**
     * 设置 HttpLog 开关
     *
     * @param log
     * @return
     */
    public final Configurator withHttpLog(boolean log) {
        ConfigMap.put(ConfigKey.OKHTTP_LOGGER, log);
        return this;
    }

    /**
     * 应用设置
     */
    public final void build() {
        ConfigMap.put(ConfigKey.CONFIG_READY, true);
    }
}
