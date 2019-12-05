package com.swolf.ly.common.factory.okhttp.ssl

import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession

class KTrustAllHostnameVerifier: HostnameVerifier {
    override fun verify(hostname: String?, session: SSLSession?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return true;
    }
}