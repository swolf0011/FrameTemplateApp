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
class KNetWorkChangeReceiver1 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        networkConnected(context, intent)
    }

    fun networkConnected(context: Context, intent: Intent) {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= 29) {
            val ca = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (ca != null) {
                var b0 = ca.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                var b1 = ca.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                KNetWorkChangeReceiver1Util.isNetworkConnected = b0 && b1
            } else {
                KNetWorkChangeReceiver1Util.isNetworkConnected = false
            }
            ca.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    && ca.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } else {
            val netInfo = connectivityManager.activeNetworkInfo
            KNetWorkChangeReceiver1Util.isNetworkConnected = netInfo.isConnected
        }
    }

}