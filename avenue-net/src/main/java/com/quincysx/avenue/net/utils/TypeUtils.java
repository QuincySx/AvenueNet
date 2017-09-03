package com.quincysx.avenue.net.utils;

import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by quincysx on 2017/9/3.
 */

public class TypeUtils {

    /**
     * 获取第一级type
     *
     * @param t
     * @param <T>
     * @return
     */
//    public static <T> Type getType(T t) {
//        Type genType = t.getClass().getGenericSuperclass();
//        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
//        Type type = params[0];
//        Type finalNeedType;
//        if (params.length > 1) {
//            if (!(type instanceof ParameterizedType)) throw new IllegalStateException("没有填写泛型参数");
//            finalNeedType = ((ParameterizedType) type).getActualTypeArguments()[0];
//        } else {
//            finalNeedType = type;
//        }
//        return finalNeedType;
//    }
    public static <T> Type getType(T subclass) {
        Type superclass = subclass.getClass().getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }

    /**
     * 获取次一级type(如果有)
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Type getSubType(T t) {
        Type genType = t.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Type type = params[0];
        Type finalNeedType;
        if (params.length > 1) {
            if (!(type instanceof ParameterizedType)) throw new IllegalStateException("没有填写泛型参数");
            finalNeedType = ((ParameterizedType) type).getActualTypeArguments()[0];
        } else {
            if (type instanceof ParameterizedType) {
                finalNeedType = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                finalNeedType = type;
            }
        }
        return finalNeedType;
    }
}
