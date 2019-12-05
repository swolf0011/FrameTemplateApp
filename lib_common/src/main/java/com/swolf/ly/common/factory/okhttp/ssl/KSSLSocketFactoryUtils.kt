package com.swolf.ly.common.factory.okhttp.ssl

import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager as X509TrustManager1

object KSSLSocketFactoryUtils {

    fun createSSLSocketFactory(): SSLSocketFactory {
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, arrayOf<TrustManager>(createTrustAllManager()), SecureRandom())
        var sslSocketFactory = sslContext.getSocketFactory()
        return sslSocketFactory
    }

    fun createTrustAllManager(): X509TrustManager1 {
        return KX509TrustManager()
    }

}

