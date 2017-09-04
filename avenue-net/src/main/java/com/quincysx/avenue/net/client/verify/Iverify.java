package com.quincysx.avenue.net.client.verify;

import com.quincysx.avenue.net.result.exception.ApiException;

/**
 * Created by wang.rongqiang on 2017/9/4.
 */

public interface Iverify {
    <T> void verify(T t) throws ApiException;
}
