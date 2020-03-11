package io.seroo.androidproblem

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class ButtonReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("GYH", "onReceive")
        context?.let { actualContext ->
            (actualContext.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager)?.let { actualManager ->
                val notificationId = intent?.getIntExtra(Constant.KEY_NOTIFICATION_ID, 0) ?: 0
                Log.d("GYH", "onReceive cancel $notificationId")
                actualContext.stopService(Intent(actualContext, ForegroundService::class.java))
                actualManager.cancel(notificationId)
            }
        }
    }
}