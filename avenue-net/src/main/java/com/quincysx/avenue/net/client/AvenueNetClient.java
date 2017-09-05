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

import android.util.Pair;

import com.quincysx.avenue.net.result.ApiCallback;
import com.quincysx.avenue.net.result.ApiCallbackSubscriber;
import com.quincysx.avenue.net.utils.RxSchedulersUtils;
import com.quincysx.avenue.net.utils.TypeUtils;

import java.io.File;
import java.lang.reflect.Type;
import java.util.WeakHashMap;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by quincysx on 2017/8/31.
 * 网络请求访问器
 */
@SuppressWarnings({"unused", "unchecked"})
public final class AvenueNetClient {
    private final String URL;
    private final WeakHashMap<String, Object> PARAMS;
    private final WeakHashMap<String, Object> HEADERS;
    private final RequestBody BODY;

    private final WeakHashMap<String, MultipartBody.Part> PART_MAP = new WeakHashMap<>();
    private final WeakHashMap<String, RequestBody> UPLOAD_PARAMS = new WeakHashMap<>();

    public static NetClientBuilder builder() {
        return new NetClientBuilder();
    }

    public static NetClientBuilder builder(String url) {
        return new NetClientBuilder(url);
    }

    private static ClientService getService() {
        return NetClientCreator.getRetrofitInstance().create(ClientService.class);
    }

    AvenueNetClient(NetClientBuilder builder) {
        URL = builder.mUrl;
        PARAMS = builder.mParams;
        BODY = builder.mBody;
        HEADERS = builder.mHeader;

        int fileIndex = 0;

        PART_MAP.clear();
        for (Pair<String, File> pair : builder.FILE_LIST) {
            RequestBody requestFile =
                    RequestBody.create(MediaType.parse("multipart/form-data"), pair.second);
            String key = "file" + fileIndex++;
            if (!pair.first.equals("")) {
                key = pair.first;
            }
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData(key, pair.second.getName(), requestFile);
            PART_MAP.put(key, body);
        }
    }

    @SuppressWarnings({"unchecked"})
    public static <T> T createService(Class aClass) {
        return (T) NetClientCreator.getRetrofitInstance().create(aClass);
    }

    private Observable request(@HTTP.Type int type) {
        if (URL == null) {
            throw new RuntimeException("IS URL NULL");
        }
        final ClientService service = getService();
        final Observable observable;
        switch (type) {
            case HTTP.GET:
                observable = service.get(URL, PARAMS, HEADERS);
                break;
            case HTTP.POST:
                observable = service.post(URL, PARAMS, HEADERS);
                break;
            case HTTP.POST_RAW:
                observable = service.postRaw(URL, BODY, HEADERS);
                break;
            case HTTP.PUT:
                observable = service.put(URL, PARAMS, HEADERS);
                break;
            case HTTP.PUT_RAW:
                observable = service.putRaw(URL, BODY, HEADERS);
                break;
            case HTTP.DELETE:
                observable = service.delete(URL, PARAMS, HEADERS);
                break;
            case HTTP.UPLOAD:
                String key1 = PART_MAP.keySet().iterator().next();
                observable = service.upload(URL, PART_MAP.get(key1), HEADERS);
                break;
            case HTTP.UPLOADS:
                observable = service.upload(URL, PART_MAP, HEADERS);
                break;
            case HTTP.UPLOAD_PARAMS:
                String key2 = PART_MAP.keySet().iterator().next();
                observable = service.upload(URL, UPLOAD_PARAMS, PART_MAP.get(key2), HEADERS);
                break;
            case HTTP.UPLOADS_PARAMS:
                observable = service.upload(URL, UPLOAD_PARAMS, PART_MAP, HEADERS);
                break;
            default:
                observable = service.get(URL, PARAMS, HEADERS);
        }
        return observable;
    }

    /**
     * GET 请求
     *
     * @param type 目标类型 T
     * @return T类型 被观察者
     */
    private <T> Observable<T> get(Type type) {
        return request(HTTP.GET)
                .compose(RxSchedulersUtils.typeTransformer(type));
    }

    public final Observable<String> get() {
        return get(String.class);
    }

    public final <T> Observable<T> get(Class<T> t) {
        return get((Type) t);
    }

    public final <T> void get(final ApiCallback<T> callback) {
        Type type = TypeUtils.getType(callback);
        DisposableObserver subscriber = new ApiCallbackSubscriber(callback);
        get(type).subscribe(subscriber);
    }


    /**
     * POST 请求
     *
     * @param type 目标类型 T
     * @return T类型 被观察者
     */
    private <T> Observable<T> post(Type type) {
        if (BODY == null) {
            return request(HTTP.POST).compose(RxSchedulersUtils.typeTransformer(type));
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("If BODY is set, make sure that PARAMS is empty");
            }
            return request(HTTP.POST_RAW).compose(RxSchedulersUtils.typeTransformer(type));
        }
    }

    public final Observable<String> post() {
        return get(String.class);
    }

    public final <T> Observable<T> post(Class<T> t) {
        return get((Type) t);
    }

    public final <T> void post(final ApiCallback<T> callback) {
        Type type = TypeUtils.getType(callback);
        DisposableObserver subscriber = new ApiCallbackSubscriber(callback);
        get(type).subscribe(subscriber);
    }


    /**
     * POST 请求
     *
     * @param type 目标类型 T
     * @return T类型 被观察者
     */
    public final <T> Observable<T> put(Type type) {
        if (BODY == null) {
            return request(HTTP.PUT).compose(RxSchedulersUtils.typeTransformer(type));
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("If BODY is set, make sure that PARAMS is empty");
            }
            return request(HTTP.PUT_RAW).compose(RxSchedulersUtils.typeTransformer(type));
        }
    }

    public final Observable<String> put() {
        return get(String.class);
    }

    public final <T> Observable<T> put(Class<T> t) {
        return get((Type) t);
    }

    public final <T> void put(final ApiCallback<T> callback) {
        Type type = TypeUtils.getType(callback);
        DisposableObserver subscriber = new ApiCallbackSubscriber(callback);
        get(type).subscribe(subscriber);
    }

    /**
     * DELETE 请求
     *
     * @param type 目标类型 T
     * @return T类型 被观察者
     */
    public final <T> Observable<T> delete(Type type) {
        return request(HTTP.DELETE).compose(RxSchedulersUtils.typeTransformer(type));
    }

    public final Observable<String> delete() {
        return get(String.class);
    }

    public final <T> Observable<T> delete(Class<T> t) {
        return get((Type) t);
    }

    public final <T> void delete(final ApiCallback<T> callback) {
        Type type = TypeUtils.getType(callback);
        DisposableObserver subscriber = new ApiCallbackSubscriber(callback);
        get(type).subscribe(subscriber);
    }

    /**
     * UPLOAD 请求
     *
     * @param type 目标类型 T
     * @return T类型 被观察者
     */
    private Observable<String> upload(Type type) {
        if (PART_MAP.size() == 0) {
            //没有文件不能上传
            throw new RuntimeException("Please pass in File first");
        } else if (PART_MAP.size() == 1 && PARAMS.size() == 0) {
            //单文件上传
            return request(HTTP.UPLOAD).compose(RxSchedulersUtils.typeTransformer(type));
        } else if (PART_MAP.size() > 1 && PARAMS.size() == 0) {
            //多文件上传
            return request(HTTP.UPLOADS).compose(RxSchedulersUtils.typeTransformer(type));
        } else {
            //文件与参数一块上传
            for (String s : PARAMS.keySet()) {
                RequestBody body = RequestBody.create(
                        MediaType.parse("multipart/form-data"), PARAMS.get(s).toString());
                UPLOAD_PARAMS.put(s, body);
            }
            if (PART_MAP.size() == 1) {
                //单文件多参数
                return request(HTTP.UPLOAD_PARAMS).compose(RxSchedulersUtils.typeTransformer(type));
            } else {
                //多文件多参数
                return request(HTTP.UPLOADS_PARAMS).compose(RxSchedulersUtils.typeTransformer(type));
            }
        }
    }

    public final Observable<String> upload() {
        return get(String.class);
    }

    public final <T> Observable<T> upload(Class<T> t) {
        return get((Type) t);
    }

    public final <T> void upload(final ApiCallback<T> callback) {
        Type type = TypeUtils.getType(callback);
        DisposableObserver subscriber = new ApiCallbackSubscriber(callback);
        get(type).subscribe(subscriber);
    }

    /**
     * UPLOAD 请求
     *
     * @param type 目标类型 T
     * @return T类型 被观察者
     */
    private <T> Observable<T> download(Type type) {
//        if (FULL_PATH == null || REQUEST.equals("")) {
//            if (SUFFIX == null || REQUEST.equals("")) {
//                throw new RuntimeException(
//                        "When you use the download function, either set the fullPath parameter or set the suffix parameter");
//            }
//        }
//        final DownloadHandler downloadHandler = new DownloadHandler(URL, DOWNLOAD_DIR, SUFFIX, FULL_PATH, SUCCESS, ERROR, FAILURE, REQUEST);
//        downloadHandler.handleDownload();
        return null;
    }
}
