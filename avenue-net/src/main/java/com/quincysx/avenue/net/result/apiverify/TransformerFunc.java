package com.quincysx.avenue.net.result.apiverify;
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

import com.alibaba.fastjson.JSON;
import com.quincysx.avenue.net.ConfigManager;

import java.lang.reflect.Type;

import io.reactivex.functions.Function;

public final class TransformerFunc<T> implements Function<String, T> {
    private Type type;

    public TransformerFunc(Type type) {
        this.type = type;
    }

    @Override
    public T apply(String json) throws Exception {
        if (type.equals(String.class)) {
            return (T) json;
        } else {
            T t = JSON.parseObject(json, type);
            ConfigManager.getApiVerify().verify(t);
            return t;
        }
    }
}
