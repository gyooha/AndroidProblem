package io.seroo.androidproblem

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi

object NotificationUtil {

    const val NOTIFICATION_CHANNEL_ID = "notification_channel_id"

    @RequiresApi(Build.VERSION_CODES.O)
    fun createChannel(context: Context) {
        (context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager)?.createNotificationChannel(
            NotificationChannel(NOTIFICATION_CHANNEL_ID, "테스트 채널", NotificationManager.IMPORTANCE_DEFAULT)
        )
    }
}