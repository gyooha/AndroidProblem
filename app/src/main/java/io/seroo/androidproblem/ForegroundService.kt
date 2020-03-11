package io.seroo.androidproblem

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import io.seroo.androidproblem.NotificationUtil.NOTIFICATION_CHANNEL_ID

class ForegroundService : Service() {
    companion object {
        const val NOTIFICATION_ID = 1
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("GYH" , "onStartCommand service start")
        val builder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
        } else {
            NotificationCompat.Builder(this)
        }

        val targetIntent = Intent(this, D_Activity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, targetIntent, 0)

        val receiverIntent = Intent(this, ButtonReceiver::class.java).apply { putExtra(Constant.KEY_NOTIFICATION_ID, NOTIFICATION_ID) }
        val pendingIntentForCancel = PendingIntent.getBroadcast(this, 0, receiverIntent, 0)


        val result = builder
            .setContentTitle("Foreground Service")
            .setContentText("test")
//            .setDeleteIntent(pendingIntentForCancel)
            .addAction(
                NotificationCompat.Action.Builder(
                    R.drawable.ic_launcher_background,
                    "close",
                    pendingIntentForCancel
                ).build()
            )
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pendingIntent)
            /*.setStyle(
                androidx.media.app.NotificationCompat.MediaStyle()
                    .setShowCancelButton(true)
                    .setCancelButtonIntent(pendingIntentForCancel)
            )*/
            .build()


        startForeground(NOTIFICATION_ID, result)

        return START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("GYH", "Service onCreate()")
    }

    override fun onDestroy() {
        Log.d("GYH", "Service onDestroy()")
        super.onDestroy()
    }
}