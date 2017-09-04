package com.quincysx.avenue.net.sample.verify;

import com.quincysx.avenue.net.client.verify.Iverify;
import com.quincysx.avenue.net.result.exception.ApiException;
import com.quincysx.avenue.net.sample.bean.BaseResponse;

/**
 * Created by wang.rongqiang on 2017/9/4.
 * 示例 模拟处理异常
 */

public class Verify implements Iverify {
    private static final class Holder {
        private static Verify Instance = new Verify();
    }

    public static Verify getInstance() {
        return Holder.Instance;
    }

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
