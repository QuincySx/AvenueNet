package com.quincysx.avenue.net.client;

import android.support.annotation.IntDef;

/**
 * Created by wang.rongqiang on 2017/9/1.
 */

public class HTTP {
    public static final int GET = 0;
    public static final int POST = 1;
    public static final int POST_RAW = 2;
    public static final int PUT = 3;
    public static final int PUT_RAW = 4;
    public static final int DELETE = 5;
    public static final int DOWNLOAD = 6;
    public static final int UPLOAD = 7;
    public static final int UPLOADS = 8;
    public static final int UPLOAD_PARAMS = 9;
    public static final int UPLOADS_PARAMS = 10;

    @IntDef({GET, POST, POST_RAW, PUT, PUT_RAW, DELETE, DOWNLOAD, UPLOAD, UPLOADS, UPLOAD_PARAMS, UPLOADS_PARAMS})
    public @interface Type {
    }
}
