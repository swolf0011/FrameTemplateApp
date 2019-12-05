package com.swolf.ly.common.util.webview

import android.net.Uri
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.JsPromptResult
import android.webkit.JsResult



class KWebChromeClient() : WebChromeClient() {

    override fun onProgressChanged(view: WebView, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
    }

    override fun onJsAlert(view: WebView, url: String, message: String, result: JsResult): Boolean {

        return true
    }

    override fun onJsConfirm(view: WebView, url: String, message: String, result: JsResult): Boolean {

        return true
    }


    override fun onJsPrompt(
        view: WebView,
        origin: String,
        message: String,
        defaultValue: String,
        result: JsPromptResult
    ): Boolean {

        return true
    }



    override fun onShowFileChooser(
        webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
        fileChooserParams: FileChooserParams
    ): Boolean {
        return true
    }
    override fun onReceivedTitle(webView: WebView, title: String) {
        super.onReceivedTitle(webView, title)
    }


}