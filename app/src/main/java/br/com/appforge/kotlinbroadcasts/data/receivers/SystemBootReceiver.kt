package br.com.appforge.kotlinbroadcasts.data.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SystemBootReceiver : BroadcastReceiver() {
    // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
    override fun onReceive(context: Context, intent: Intent) {

        //Static Broadcast (setup added at the AndroidManifest.xml)
        if(intent.action == Intent.ACTION_BOOT_COMPLETED){
            Log.i("info_broadcast", "System boot completed.")
        }

        //

    }
}