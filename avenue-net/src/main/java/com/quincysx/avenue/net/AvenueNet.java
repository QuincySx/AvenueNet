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
