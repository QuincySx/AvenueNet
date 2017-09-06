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

import android.support.annotation.NonNull;

import com.quincysx.avenue.net.logger.DefLogger;
import com.quincysx.avenue.net.logger.Logger;
import com.quincysx.avenue.net.result.apierror.DefApiErrorHandle;
import com.quincysx.avenue.net.result.apierror.IApiErrorHandle;
import com.quincysx.avenue.net.result.apiverify.DefApiVerify;
import com.quincysx.avenue.net.result.apiverify.IApiVerify;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by quincysx on 2017/8/31.
 * 配置管理器
 */

@SuppressWarnings({"unused", "JavaDoc"})
public final class Configurator {
    private final IConfigManager mConfigManager;
    private final HashMap<String, String> mHeaderHashMap = new HashMap<>();

    public static Configurator newInstance(IConfigManager manager) {
        return new Configurator(manager);
    }

    private Configurator(IConfigManager manager) {
        mConfigManager = manager;
        mConfigManager.setConfig(ConfigKey.CONFIG_READY, false);
        mConfigManager.setConfig(ConfigKey.OKHTTP_LOGGER, false);
        mConfigManager.setConfig(ConfigKey.ERROR_HANDLE, new DefApiErrorHandle());
        mConfigManager.setConfig(ConfigKey.VERIFY_CLIENT, new DefApiVerify());
        mConfigManager.setConfig(ConfigKey.LOGGER_CLIENT, new DefLogger());
        mConfigManager.setConfig(ConfigKey.COMMON_HTTP_HEADER, mHeaderHashMap);
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
    public final Configurator withApiHost(@NonNull String host) {
        mConfigManager.setConfig(ConfigKey.BASE_URL, host);
        return this;
    }

    /**
     * 设置 HttpLog 开关
     *
     * @param log
     * @return
     */
    public final Configurator withHttpLog(boolean log) {
        mConfigManager.setConfig(ConfigKey.OKHTTP_LOGGER, log);
        return this;
    }

    /**
     * 设置超时时间 单位秒
     *
     * @param second
     * @return
     */
    public final Configurator withHttpTimeout(long second) {
        mConfigManager.setConfig(ConfigKey.HTTP_TIME_OUT, second);
        return this;
    }

    /**
     * 设置Logger打印对象
     *
     * @param logger
     * @return
     */
    public final Configurator withLogger(@NonNull Logger logger) {
        mConfigManager.setConfig(ConfigKey.LOGGER_CLIENT, logger);
        return this;
    }

    /**
     * 设置数据验证对象
     *
     * @param verify
     * @return
     */
    public final Configurator withVerify(@NonNull IApiVerify verify) {
        mConfigManager.setConfig(ConfigKey.VERIFY_CLIENT, verify);
        return this;
    }

    /**
     * 数据异常处理
     *
     * @param handle
     * @return
     */
    public final Configurator withErrorHandle(@NonNull IApiErrorHandle handle) {
        mConfigManager.setConfig(ConfigKey.ERROR_HANDLE, handle);
        return this;
    }

    /**
     * 添加公共请求头
     *
     * @return
     */
    public final Configurator withHeader(@NonNull String key, String header) {
        mHeaderHashMap.put(key, header);
        mConfigManager.setConfig(ConfigKey.COMMON_HTTP_HEADER, mHeaderHashMap);
        return this;
    }

    /**
     * 添加公共请求头
     *
     * @param headers
     * @return
     */
    public final Configurator withHeader(@NonNull Map<String, String> headers) {
        mHeaderHashMap.putAll(headers);
        mConfigManager.setConfig(ConfigKey.COMMON_HTTP_HEADER, mHeaderHashMap);
        return this;
    }

    /**
     * 应用设置
     */
    public final void build() {
        mConfigManager.setConfig(ConfigKey.CONFIG_READY, true);
    }
}
