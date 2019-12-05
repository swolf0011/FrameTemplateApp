package com.swolf.ly.common.factory.okhttp

import com.swolf.ly.common.factory.okhttp.ssl.KSSLSocketFactoryUtils
import com.swolf.ly.common.factory.okhttp.ssl.KTrustAllHostnameVerifier
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class KOkHttpUtil {
    companion object {
        private var timeout: Long = 30000
        private var milliseconds = TimeUnit.MILLISECONDS
        //初始化一个OkHttpClient
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(timeout, milliseconds)
            .readTimeout(timeout, milliseconds)
            .writeTimeout(timeout, milliseconds)
            .sslSocketFactory(KSSLSocketFactoryUtils.createSSLSocketFactory(),KSSLSocketFactoryUtils.createTrustAllManager())
            .hostnameVerifier(KTrustAllHostnameVerifier())
            .build()
    }
}