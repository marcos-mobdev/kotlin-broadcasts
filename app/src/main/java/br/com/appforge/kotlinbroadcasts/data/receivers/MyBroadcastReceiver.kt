package br.com.appforge.kotlinbroadcasts.data.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.util.Log
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.

        val wifiStatus = intent.getIntExtra(
            WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN
        )

        val wifiStatusMessage = when(wifiStatus){
            WifiManager.WIFI_STATE_ENABLED-> "Wi-Fi Enabled"
            WifiManager.WIFI_STATE_DISABLED-> "Wi-Fi Disabled"
            WifiManager.WIFI_STATE_ENABLING-> "Wi-Fi Enabling"
            WifiManager.WIFI_STATE_DISABLING-> "Wi-Fi Disabling"
            else -> ""
        }

        val batteryStatusMessage = when(intent.action){
            Intent.ACTION_BATTERY_LOW -> "ACTION_BATTERY_LOW"
            Intent.ACTION_POWER_CONNECTED -> "ACTION_POWER_CONNECTED"
            Intent.ACTION_POWER_DISCONNECTED -> "ACTION_POWER_DISCONNECTED"
            //WifiManager.WIFI_STATE_CHANGED_ACTION -> "WIFI_STATE_CHANGED_ACTION" //For
            else-> ""
        }

        if (batteryStatusMessage.isNotEmpty()) {
            Toast.makeText(context, batteryStatusMessage, Toast.LENGTH_SHORT).show()
            Log.i("info_broadcast", "battery: $batteryStatusMessage")
        }
        if(wifiStatusMessage.isNotEmpty()){
            Toast.makeText(context, wifiStatusMessage, Toast.LENGTH_SHORT).show()
            Log.i("info_broadcast", "wifi: $wifiStatusMessage")
        }

    }
}