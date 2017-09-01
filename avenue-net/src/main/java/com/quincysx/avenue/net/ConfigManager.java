package com.quincysx.avenue.net;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wang.rongqiang on 2017/9/1.
 * 公共配置项存储管理
 */

public final class ConfigManager implements IConfigManager {
    private final Map<String, Object> ConfigMap = new HashMap<>();

    private final static class Holder {
        private final static ConfigManager Instance = new ConfigManager();
    }

    public static ConfigManager getInstance() {
        return Holder.Instance;
    }

    public void setConfig(@ConfigKey.Key String key, Object value) {
        ConfigMap.put(key, value);
    }

    public <T> T getConfig(@ConfigKey.Key String key) {
        final boolean exists = (boolean) ConfigMap.get(ConfigKey.CONFIG_READY);
        if (!exists) {
            throw new RuntimeException("is NetWork Not Ready");
        }
        final Object value = ConfigMap.get(key);
        if (value == null) {
            throw new NullPointerException(key + " IS NULL");
        }
        return (T) value;
    }
}
