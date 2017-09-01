package com.quincysx.avenue.net.client;

import android.util.Pair;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.RequestBody;

/**
 * Created by quincysx on 2017/8/31.
 */

public final class NetClientBuilder {
    String mUrl = null;
    WeakHashMap<String, Object> mParams = new WeakHashMap<>();
    RequestBody mBody = null;

    final ArrayList<Pair<String, File>> FILE_LIST = new ArrayList<>();

    NetClientBuilder() {
    }

    public NetClientBuilder url(String url) {
        mUrl = url;
        return this;
    }

    /**
     * 添加请求参数
     *
     * @param key   参数key
     * @param value 参数值
     */
    public NetClientBuilder addParam(String key, Object value) {
        mParams.put(key, value);
        return this;
    }

    /**
     * 添加一些请求参数
     *
     * @param params 参数键值对
     */
    public NetClientBuilder addParams(Map<String, Object> params) {
        mParams.putAll(params);
        return this;
    }

    public NetClientBuilder addFile(String key, File val) {
        FILE_LIST.add(new Pair<>(key, val));
        return this;
    }

    public NetClientBuilder addFile(String key, String val) {
        addFile(key, new File(val));
        return this;
    }

    public NetClientBuilder setBody(RequestBody val) {
        mBody = val;
        return this;
    }

    /**
     * 构建连接Client
     */
    public AvenueNetClient build() {
        return new AvenueNetClient(this);
    }
}
