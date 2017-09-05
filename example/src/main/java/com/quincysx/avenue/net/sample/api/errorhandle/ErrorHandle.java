package com.quincysx.avenue.net.sample.api.errorhandle;

import android.content.Context;
import android.widget.Toast;

import com.quincysx.avenue.net.AvenueNet;
import com.quincysx.avenue.net.ConfigKey;
import com.quincysx.avenue.net.result.apierror.IApiErrorHandle;
import com.quincysx.avenue.net.result.exception.ApiException;

import java.util.concurrent.TimeoutException;

/**
 * Created by wang.rongqiang on 2017/9/5.
 */

public class ErrorHandle implements IApiErrorHandle {
    @Override
    public ApiException onHandle(Throwable t) {
        final Context context = AvenueNet.getConfig(ConfigKey.APP_CONTEXT);

        final ApiException exception;
        if (t instanceof ApiException) {
            exception = (ApiException) t;
        } else if (t instanceof TimeoutException) {
            exception = new ApiException(10001, "超时");
        } else {
            exception = new ApiException(-1, "未知错误");
        }
        Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
        return exception;
    }
}
