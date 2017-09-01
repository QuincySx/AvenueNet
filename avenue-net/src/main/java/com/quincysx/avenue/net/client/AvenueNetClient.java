package com.quincysx.avenue.net.client;

import android.util.Pair;

import java.io.File;
import java.util.WeakHashMap;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by quincysx on 2017/8/31.
 * 网络请求访问器
 */
@SuppressWarnings({"unused", "DefaultFileTemplate"})
public class AvenueNetClient {
    private final String URL;
    private final WeakHashMap<String, Object> PARAMS;
    private final RequestBody BODY;

    private final WeakHashMap<String, MultipartBody.Part> PART_MAP = new WeakHashMap<>();
    private final WeakHashMap<String, RequestBody> UPLOAD_PARAMS = new WeakHashMap<>();

    public static NetClientBuilder Builder() {
        return new NetClientBuilder();
    }

    public static ClientService getService() {
        return NetClientCreator.getRetrofitInstance().create(ClientService.class);
    }

    public AvenueNetClient(NetClientBuilder builder) {
        URL = builder.mUrl;
        PARAMS = builder.mParams;
        BODY = builder.mBody;

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
        final ClientService service = getService();
        final Observable observable;
        switch (type) {
            case HTTP.GET:
                observable = service.get(URL, PARAMS);
                break;
            case HTTP.POST:
                observable = service.post(URL, PARAMS);
                break;
            case HTTP.POST_RAW:
                observable = service.postRaw(URL, BODY);
                break;
            case HTTP.PUT:
                observable = service.put(URL, PARAMS);
                break;
            case HTTP.PUT_RAW:
                observable = service.putRaw(URL, BODY);
                break;
            case HTTP.DELETE:
                observable = service.delete(URL, PARAMS);
                break;
            case HTTP.UPLOAD:
                String key1 = PART_MAP.keySet().iterator().next();
                observable = service.upload(URL, PART_MAP.get(key1));
                break;
            case HTTP.UPLOADS:
                observable = service.upload(URL, PART_MAP);
                break;
            case HTTP.UPLOAD_PARAMS:
                String key2 = PART_MAP.keySet().iterator().next();
                observable = service.upload(URL, UPLOAD_PARAMS, PART_MAP.get(key2));
                break;
            case HTTP.UPLOADS_PARAMS:
                observable = service.upload(URL, UPLOAD_PARAMS, PART_MAP);
                break;
            default:
                observable = service.get(URL, PARAMS);
        }
        return observable;
    }

    public Observable get() {
        return request(HTTP.GET);
    }

    public final Observable post() {
        if (BODY == null) {
            return request(HTTP.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("If BODY is set, make sure that PARAMS is empty");
            }
            return request(HTTP.POST_RAW);
        }
    }

    public final Observable put() {
        if (BODY == null) {
            return request(HTTP.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("If BODY is set, make sure that PARAMS is empty");
            }
            return request(HTTP.PUT_RAW);
        }
    }

    public final Observable delete() {
        return request(HTTP.DELETE);
    }

    public final Observable upload() {
        if (PART_MAP.size() == 0) {
            //没有文件不能上传
            throw new RuntimeException("Please pass in File first");
        } else if (PART_MAP.size() == 1 && PARAMS.size() == 0) {
            //单文件上传
            return request(HTTP.UPLOAD);
        } else if (PART_MAP.size() > 1 && PARAMS.size() == 0) {
            //多文件上传
            return request(HTTP.UPLOADS);
        } else {
            //文件与参数一块上传
            for (String s : PARAMS.keySet()) {
                RequestBody body = RequestBody.create(
                        MediaType.parse("multipart/form-data"), PARAMS.get(s).toString());
                UPLOAD_PARAMS.put(s, body);
            }
            if (PART_MAP.size() == 1) {
                //单文件多参数
                return request(HTTP.UPLOAD_PARAMS);
            } else {
                //多文件多参数
                return request(HTTP.UPLOADS_PARAMS);
            }
        }
    }

    public final void download() {
//        if (FULL_PATH == null || REQUEST.equals("")) {
//            if (SUFFIX == null || REQUEST.equals("")) {
//                throw new RuntimeException(
//                        "When you use the download function, either set the fullPath parameter or set the suffix parameter");
//            }
//        }
//        final DownloadHandler downloadHandler = new DownloadHandler(URL, DOWNLOAD_DIR, SUFFIX, FULL_PATH, SUCCESS, ERROR, FAILURE, REQUEST);
//        downloadHandler.handleDownload();
    }
}
