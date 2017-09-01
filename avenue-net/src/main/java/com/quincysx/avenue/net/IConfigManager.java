package com.quincysx.avenue.net;

/**
 * Created by wang.rongqiang on 2017/9/1.
 * 配置项设置的接口
 */

public interface IConfigManager {

    public void setConfig(@ConfigKey.Key String key, Object value);

    public <T> T getConfig(@ConfigKey.Key String key);
}
