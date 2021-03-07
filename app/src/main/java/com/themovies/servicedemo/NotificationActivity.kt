package com.themovies.servicedemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder
import com.themovies.servicedemo.databinding.ActivityNotificationAcivityBinding

class NotificationActivity : AppCompatActivity() {

    companion object {
        private const val CHANNEL_ID = "CHANNEL_ID"
        private const val CHANNEL_NAME = "Awesome"
        private const val NOTIFICATION_ID = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNotificationAcivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createNotificationChannel()

        val intent = Intent(this, NotificationActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Awesome notification")
            .setContentText("Mad group is Awesome")
            .setSmallIcon(R.drawable.ic_stat_name)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)

        binding.notify.setOnClickListener {
            notificationManager.notify(
                NOTIFICATION_ID,
                notification
            )
        }
    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                lightColor = Color.RED
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}