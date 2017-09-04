package com.quincysx.avenue.net;

import android.support.annotation.NonNull;

import com.quincysx.avenue.net.client.verify.Iverify;
import com.quincysx.avenue.net.logger.Logger;

/**
 * Created by quincysx on 2017/8/31.
 * 配置管理器
 */

@SuppressWarnings({"unused", "JavaDoc"})
public final class Configurator {
    private final IConfigManager mConfigManager;

    public static Configurator newInstance(IConfigManager manager) {
        return new Configurator(manager);
    }

    private Configurator(IConfigManager manager) {
        mConfigManager = manager;
        mConfigManager.setConfig(ConfigKey.CONFIG_READY, false);
        mConfigManager.setConfig(ConfigKey.OKHTTP_LOGGER, false);
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
    public final Configurator withVerify(@NonNull Iverify verify) {
        mConfigManager.setConfig(ConfigKey.Verify_CLIENT, verify);
        return this;
    }

    /**
     * 应用设置
     */
    public final void build() {
        mConfigManager.setConfig(ConfigKey.CONFIG_READY, true);
    }
}
