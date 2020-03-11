package io.seroo.androidproblem

import android.app.Application
import android.os.Build

class SerooApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) NotificationUtil.createChannel(this@SerooApplication)
    }
}