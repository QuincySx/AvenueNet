package com.quincysx.avenue.net.client;
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
    WeakHashMap<String, Object> mHeader = new WeakHashMap<>();
    RequestBody mBody = null;

    final ArrayList<Pair<String, File>> FILE_LIST = new ArrayList<>();

    NetClientBuilder() {
    }

    NetClientBuilder(String url) {
        mUrl = url;
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

    /**
     * 添加请求头
     *
     * @param key    参数key
     * @param header 参数值
     */
    public NetClientBuilder addHeader(String key, Object header) {
        mHeader.put(key, header);
        return this;
    }

    /**
     * 添加一些请求头
     *
     * @param headers 参数键值对
     */
    public NetClientBuilder addHeaders(Map<String, Object> headers) {
        mHeader.putAll(headers);
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
