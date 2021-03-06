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

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by quincysx on 2017/8/31.
 */

interface ClientService {
    @GET
    Observable<String> get(@Url String url, @QueryMap Map<String, Object> params, @HeaderMap Map<String, Object> header);

    @FormUrlEncoded
    @POST
    Observable<String> post(@Url String url, @FieldMap Map<String, Object> params, @HeaderMap Map<String, Object> header);

    @POST
    Observable<String> postRaw(@Url String url, @Body RequestBody body, @HeaderMap Map<String, Object> header);

    @FormUrlEncoded
    @PUT
    Observable<String> put(@Url String url, @FieldMap Map<String, Object> params, @HeaderMap Map<String, Object> header);

    @PUT
    Observable<String> putRaw(@Url String url, @Body RequestBody body, @HeaderMap Map<String, Object> header);

    @DELETE
    Observable<String> delete(@Url String url, @QueryMap Map<String, Object> params, @HeaderMap Map<String, Object> header);

    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url, @QueryMap Map<String, Object> params, @HeaderMap Map<String, Object> header);

    @Multipart
    @POST
    Observable<String> upload(@Url String url, @Part MultipartBody.Part file, @HeaderMap Map<String, Object> header);

    @Multipart
    @POST
    Observable<String> upload(@Url String url, @PartMap Map<String, MultipartBody.Part> files, @HeaderMap Map<String, Object> header);

    @Multipart
    @POST
    Observable<String> upload(@Url String url, @PartMap Map<String, RequestBody> params, @Part MultipartBody.Part file, @HeaderMap Map<String, Object> header);

    @Multipart
    @POST
    Observable<String> upload(@Url String url, @PartMap Map<String, RequestBody> params, @PartMap Map<String, MultipartBody.Part> files, @HeaderMap Map<String, Object> header);
}
