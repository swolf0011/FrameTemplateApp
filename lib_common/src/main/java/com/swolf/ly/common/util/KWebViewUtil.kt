package com.swolf.ly.kotlin.nycommonlib.util

import android.annotation.SuppressLint
import android.webkit.*
import com.swolf.ly.common.util.webview.KWebChromeClient
import com.swolf.ly.common.util.webview.KWebViewClient
import android.webkit.ValueCallback



object KWebViewUtil {


    fun evaluateJavascript(webView: WebView, pkFunName: String, json: String, callback: ValueCallback<String>?) {
        webView.evaluateJavascript("javascript:$pkFunName($json)", callback)
    }

    @SuppressLint("JavascriptInterface")
    fun initWebView(webView: WebView, jsObj: Any, name: String = "jsObj") {
        webView.settings.javaScriptEnabled = true//如果访问的页面中要与Javascript交互，则必须设置支持Javascript
        webView.settings.javaScriptCanOpenWindowsAutomatically = true//支持通过JS打开新窗口
        webView.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
        webView.settings.allowFileAccess = true//设置可以访问文件
        webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE//不缓存
        webView.settings.domStorageEnabled = true// 开启 DOM storage API 功能
        webView.settings.databaseEnabled = true  //开启 database storage API 功能
        webView.settings.setAppCacheEnabled(true)  //开启 Application Caches 功能
        webView.settings.getUserAgentString()// Fix for CB-1405 Google issue 4641

        webView.settings.setSupportZoom(false)
        webView.settings.builtInZoomControls = false
        webView.settings.displayZoomControls = false
        webView.settings.useWideViewPort = true
        webView.settings.loadWithOverviewMode = true
        webView.addJavascriptInterface(jsObj, name)
        webView.webChromeClient = KWebChromeClient()
        webView.webViewClient = KWebViewClient()
    }
}


