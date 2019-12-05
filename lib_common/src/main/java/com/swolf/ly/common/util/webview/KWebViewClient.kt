package com.swolf.ly.common.util.webview

import android.webkit.*
import android.net.http.SslError
import android.webkit.SslErrorHandler



class KWebViewClient() : WebViewClient() {
    override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
        super.onReceivedError(view, request, error)
        if (request.isForMainFrame()){
            // 在这里显示自定义错误页
        }
    }
    override fun onReceivedHttpError(view: WebView, request: WebResourceRequest, errorResponse: WebResourceResponse) {
        super.onReceivedHttpError(view, request, errorResponse)
        if (request.isForMainFrame()){
            // 在这里显示自定义错误页
        }
    }
    override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {

    }
}