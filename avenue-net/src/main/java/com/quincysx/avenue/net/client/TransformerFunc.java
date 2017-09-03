package com.quincysx.avenue.net.client;

import com.google.gson.Gson;

import java.lang.reflect.Type;

import io.reactivex.functions.Function;

public class TransformerFunc<T> implements Function<String, T> {
    private Type type;

    public TransformerFunc(Type type) {
        this.type = type;
    }

    @Override
    public T apply(String json) throws Exception {
        Gson gson = new Gson();
        if (type.equals(String.class)) {
            return (T) json;
        } else {
            return gson.fromJson(json, type);
        }
    }
}
