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

import android.support.annotation.IntDef;

/**
 * Created by wang.rongqiang on 2017/9/1.
 */

final class HTTP {
    static final int GET = 0;
    static final int POST = 1;
    static final int POST_RAW = 2;
    static final int PUT = 3;
    static final int PUT_RAW = 4;
    static final int DELETE = 5;
    static final int DOWNLOAD = 6;
    static final int UPLOAD = 7;
    static final int UPLOADS = 8;
    static final int UPLOAD_PARAMS = 9;
    static final int UPLOADS_PARAMS = 10;

    @IntDef({GET, POST, POST_RAW, PUT, PUT_RAW, DELETE, DOWNLOAD, UPLOAD, UPLOADS, UPLOAD_PARAMS, UPLOADS_PARAMS})
    @interface Type {
    }
}
