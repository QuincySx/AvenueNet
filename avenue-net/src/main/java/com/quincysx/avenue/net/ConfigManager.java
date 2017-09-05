package com.quincysx.avenue.net;
/*
 * Copyright (C) 2017 QuincySx<quincysx@sina.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.quincysx.avenue.net.logger.Logger;
import com.quincysx.avenue.net.logger.NativeLogger;
import com.quincysx.avenue.net.result.apierror.DefApiErrorHandle;
import com.quincysx.avenue.net.result.apierror.IApiErrorHandle;
import com.quincysx.avenue.net.result.apiverify.DefApiVerify;
import com.quincysx.avenue.net.result.apiverify.IApiVerify;

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

    /**
     * 获得Logger打印对象
     *
     * @return Logger 打印器
     */
    public static Logger getLogger() {
        try {
            return ConfigManager.getInstance().getConfig(ConfigKey.LOGGER_CLIENT);
        } catch (Exception e) {
            return NativeLogger.getInstance();
        }
    }

    /**
     * 获取 Api 接口数据验证对象
     */
    public static IApiVerify getApiVerify() {
        try {
            return ConfigManager.getInstance().getConfig(ConfigKey.VERIFY_CLIENT);
        } catch (Exception e) {
            return DefApiVerify.getInstance();
        }
    }

    /**
     * 获取 Api 异常处理接口
     */
    public static IApiErrorHandle getApiErrorHandle() {
        try {
            return ConfigManager.getInstance().getConfig(ConfigKey.ERROR_HANDLE);
        } catch (Exception e) {
            return DefApiErrorHandle.getInstance();
        }
    }
}
