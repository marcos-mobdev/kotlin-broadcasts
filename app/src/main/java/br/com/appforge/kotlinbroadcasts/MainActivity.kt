package br.com.appforge.kotlinbroadcasts

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.appforge.kotlinbroadcasts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var myBroadcastReceiver: MyBroadcastReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initializeBroadcast()
        checkWifiStatus()
    }

    private fun checkWifiStatus(){
        val wifiManager = getSystemService(WifiManager::class.java)
        //Alternative:
        //val wifiManager = getSystemService(Context.WIFI_SERVICE) as WifiManager
        if(wifiManager.isWifiEnabled){
            binding.textView.text = "Wi-Fi Enabled"
        }else{
            binding.textView.text = "Wi-Fi Disabled"
        }
    }

    private fun initializeBroadcast(){
        myBroadcastReceiver = MyBroadcastReceiver()

        IntentFilter().apply {
            addAction(Intent.ACTION_BATTERY_LOW)
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
        }.also { intentFilter ->
            registerReceiver(myBroadcastReceiver, intentFilter)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadcastReceiver)
    }
}