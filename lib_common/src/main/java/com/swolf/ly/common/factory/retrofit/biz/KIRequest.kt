package com.swolf.ly.common.factory.retrofit.biz

import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*

interface KIRequest {
    @FormUrlEncoded
    @GET
    abstract fun getQueryMap(@Url url: String, @HeaderMap headerMap: Map<String, String>, @QueryMap params: Map<String, String>): Observable<String>

    @FormUrlEncoded
    @POST
    abstract fun postKey(@Url url: String, @HeaderMap headerMap: Map<String, String>, @FieldMap params: Map<String, Any>): Observable<String>

    @FormUrlEncoded
    @POST
    abstract fun postJson(@Url url: String, @HeaderMap headerMap: Map<String, String>, @Body requestBody: RequestBody): Observable<String>

    @FormUrlEncoded
    @GET
    abstract fun download(@Url fileUrl: String): Observable<ResponseBody>

    @FormUrlEncoded
    @Multipart
    @POST
    abstract fun upload1(@Url url: String, @HeaderMap headerMap: Map<String, String>, @Part requestBody: RequestBody): Observable<String>

    @FormUrlEncoded
    @Multipart
    @POST
    abstract fun upload2(@Url url: String, @HeaderMap headerMap: Map<String, String>, @Part uploadFile: MultipartBody.Part): Observable<String>

    @FormUrlEncoded
    @Multipart
    @POST
    abstract fun uploads(@Url url: String, @HeaderMap headerMap: Map<String, String>, @PartMap partMap: Map<String, RequestBody>): Observable<String>
}