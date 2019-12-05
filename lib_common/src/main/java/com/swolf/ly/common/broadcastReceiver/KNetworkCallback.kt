package com.swolf.ly.common.broadcastReceiver

import android.net.ConnectivityManager
import android.net.Network

class KNetworkCallback: ConnectivityManager.NetworkCallback() {
    override fun onLost(network: Network){
        super.onLost(network)
        KNetWorkChangeReceiver0Util.isNetworkConnected = false
    }
    override fun onAvailable(network: Network){
        super.onAvailable(network)
        KNetWorkChangeReceiver0Util.isNetworkConnected = true
    }
}