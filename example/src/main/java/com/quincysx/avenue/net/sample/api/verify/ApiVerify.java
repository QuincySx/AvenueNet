package com.quincysx.avenue.net.sample.api.verify;

import com.quincysx.avenue.net.result.apiverify.IApiVerify;
import com.quincysx.avenue.net.result.exception.ApiException;
import com.quincysx.avenue.net.sample.bean.BaseResponse;

/**
 * Created by wang.rongqiang on 2017/9/4.
 * 示例 模拟处理异常
 */

public class ApiVerify implements IApiVerify {
    @Override
    public synchronized <T> void verify(T t) throws ApiException {
        if (t instanceof BaseResponse) {
            BaseResponse data = (BaseResponse) t;
            if (data.code != 200) {
                throw new ApiException(data.code, data.message);
            }
        }
    }
}
