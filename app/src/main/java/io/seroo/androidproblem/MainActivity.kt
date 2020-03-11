package io.seroo.androidproblem

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.seroo.androidproblem.Constant.KEY_BROAD_CAST_RECEIVER_ACTION
import io.seroo.androidproblem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val receiver = ButtonReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerReceiver(receiver, IntentFilter(KEY_BROAD_CAST_RECEIVER_ACTION))

        binding.tv.text = "A"
        binding.tv.setOnClickListener {
           /* Intent(this@MainActivity, B_Activity::class.java)
                .also(::startActivity)*/

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(Intent(this@MainActivity, ForegroundService::class.java))
            } else {
                startService(Intent(this@MainActivity, ForegroundService::class.java))
            }
        }
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.d("GYH", "onNewIntent : MainActivity")
    }
}
