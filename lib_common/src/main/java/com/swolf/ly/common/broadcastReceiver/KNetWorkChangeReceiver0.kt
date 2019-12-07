package com.swolf.ly.common.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build

/**
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />

<intent-filter>
<action android:name="android.net.conn.CONNECTIVITY_CHANGE" />
<action android:name="android.net.wifi.WIFI_STATE_CHANGED" />
<action android:name="android.net.wifi.STATE_CHANGE" />
</intent-filter>
 */
class KNetWorkChangeReceiver0 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        networkConnected(context)
    }

    fun networkConnected(context: Context) {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.requestNetwork(NetworkRequest.Builder().build(),KNetworkCallback())
    }
}