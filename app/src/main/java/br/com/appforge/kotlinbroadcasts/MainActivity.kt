package br.com.appforge.kotlinbroadcasts

import android.content.Intent
import android.content.IntentFilter
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
    }

    private fun initializeBroadcast(){
        myBroadcastReceiver = MyBroadcastReceiver()

        IntentFilter().apply {
            addAction(Intent.ACTION_BATTERY_LOW)
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }.also { intentFilter ->
            registerReceiver(myBroadcastReceiver, intentFilter)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadcastReceiver)
    }
}