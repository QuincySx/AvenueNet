package com.quincysx.avenue.net.result.apierror;

import com.quincysx.avenue.net.result.exception.ApiException;

/**
 * Created by wang.rongqiang on 2017/9/5.
 */

public interface IApiErrorHandle {
    ApiException onHandle(Throwable t);
}
