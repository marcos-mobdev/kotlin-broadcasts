package br.com.appforge.kotlinbroadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val message = when(intent.action){
            Intent.ACTION_BATTERY_LOW -> "ACTION_BATTERY_LOW"
            Intent.ACTION_POWER_CONNECTED -> "ACTION_POWER_CONNECTED"
            Intent.ACTION_POWER_DISCONNECTED -> "ACTION_POWER_DISCONNECTED"
            else-> "UNKNOWN ACTION"
        }
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}