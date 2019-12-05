package com.swolf.ly.common.factory.retrofit.biz

import com.swolf.ly.common.factory.retrofit.KRetrofitUtil
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import java.io.File
import java.util.HashMap
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.RequestBody.Companion.asRequestBody


class KRequestAPI {

    fun getQueryMap(
        url: String,
        headerMap: Map<String, String>,
        params: Map<String, String>,
        observer: Observer<String>
    ) {
        KRetrofitUtil.instance.mRetrofit.create(KIRequest::class.java)
            .getQueryMap(url, headerMap, params).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun postKey(url: String, headerMap: Map<String, String>, params: Map<String, Any>, observer: Observer<String>) {
        KRetrofitUtil.instance.mRetrofit.create(KIRequest::class.java)
            .postKey(url, headerMap, params).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun postJson(url: String, headerMap: Map<String, String>, json: String, observer: Observer<String>) {
        val mt = "application/json; charset=utf-8".toMediaType()
        val requestBody = json.toRequestBody(mt)
        val request = KRetrofitUtil.instance.mRetrofit.create(KIRequest::class.java)
        request.postJson(url, headerMap, requestBody).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun download(url: String, observer: Observer<ResponseBody>) {
        KRetrofitUtil.instance.mRetrofit.create(KIRequest::class.java)
            .download(url).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun upload1(url: String, file: File, observer: Observer<String>) {
        upload1(url, file, observer, HashMap<String, String>(), "multipart/form-data")
    }

    fun upload1(url: String, file: File, observer: Observer<String>, headerMap: Map<String, String>) {
        upload1(url, file, observer, headerMap, "multipart/form-data")
    }

    fun upload1(url: String, file: File, observer: Observer<String>, mediaType: String) {
        upload1(url, file, observer, HashMap<String, String>(), mediaType)
    }

    fun upload1(
        url: String,
        file: File,
        observer: Observer<String>,
        headerMap: Map<String, String>,
        mediaType: String?
    ) {
        val mtStr = mediaType ?: "multipart/form-data"
        val mt = mtStr.toMediaType()
        val requestBody = file.asRequestBody(mt)
        val request = KRetrofitUtil.instance.mRetrofit.create(KIRequest::class.java)
        request.upload1(url, headerMap, requestBody).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun upload2(url: String, key: String, file: File, observer: Observer<String>) {
        upload2(url, key, file, observer, HashMap<String, String>(), "multipart/form-data")
    }

    fun upload2(url: String, key: String, file: File, observer: Observer<String>, mediaType: String) {
        upload2(url, key, file, observer, HashMap<String, String>(), mediaType)
    }

    fun upload2(url: String, key: String, file: File, observer: Observer<String>, headerMap: Map<String, String>) {
        upload2(url, key, file, observer, headerMap, "multipart/form-data")
    }

    fun upload2(
        url: String,
        key: String,
        file: File,
        observer: Observer<String>,
        headerMap: Map<String, String>,
        mediaType: String?
    ) {
        val mtStr = mediaType ?: "multipart/form-data"
        val mt = mtStr.toMediaType()
        val requestBody = file.asRequestBody(mt)
        // MultipartBody.Part  和后端约定好Key，这里的partName是用file
        val body = MultipartBody.Part.createFormData(key, file.name, requestBody)
        val request = KRetrofitUtil.instance.mRetrofit.create(KIRequest::class.java)
        request.upload2(url, headerMap, body).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun uploads(url: String, fileKey: String, files: List<File>, observer: Observer<String>) {
        uploads(url, fileKey, files, observer, HashMap<String, String>(), "multipart/form-data")
    }

    fun uploads(url: String, fileKey: String, files: List<File>, observer: Observer<String>, mediaType: String) {
        uploads(url, fileKey, files, observer, HashMap<String, String>(), mediaType)
    }

    fun uploads(
        url: String,
        fileKey: String,
        files: List<File>,
        observer: Observer<String>,
        headerMap: Map<String, String>
    ) {
        uploads(url, fileKey, files, observer, headerMap, "multipart/form-data")
    }

    fun uploads(
        url: String,
        fileKey: String,
        files: List<File>,
        observer: Observer<String>,
        headerMap: Map<String, String>,
        mediaType: String
    ) {
        val partMap = HashMap<String, RequestBody>()
        val mtStr = mediaType ?: "multipart/form-data"
        val mt = mtStr.toMediaType()
        for (file in files) {
            val requestBody = file.asRequestBody(mt)
            partMap[fileKey + "\"; filename=\"" + file.name] = requestBody
        }
        val request = KRetrofitUtil.instance.mRetrofit.create(KIRequest::class.java)
        request.uploads(url, headerMap, partMap).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}