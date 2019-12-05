package com.swolf.ly.common.factory.okhttp.ssl

import java.security.cert.X509Certificate
import javax.net.ssl.X509TrustManager

class KX509TrustManager() : X509TrustManager {
    override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //do nothing，接受任意客户端证书
    }

    override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //do nothing，接受任意服务端证书
    }

    override fun getAcceptedIssuers(): Array<X509Certificate?> {
        return arrayOfNulls(0)
    }
}