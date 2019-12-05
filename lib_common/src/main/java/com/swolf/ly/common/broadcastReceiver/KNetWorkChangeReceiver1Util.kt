package com.swolf.ly.common.broadcastReceiver

import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager

object KNetWorkChangeReceiver1Util {

    var isNetworkConnected:Boolean = true

    fun registerReceiver(context: Context){
        var filter = IntentFilter()
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        context.registerReceiver(KNetWorkChangeReceiver1(), filter)
    }
}