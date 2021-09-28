package com.example.jetpacktutorial.notification

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.databinding.DataBindingUtil
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityNotificationTwoBinding

class NotificationTwoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNotificationTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_notification_two)
        receiveInput()
    }

    private fun receiveInput(){
        val REPLY_KEY = "reply_key"
        val intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if (remoteInput!=null)
        {
            val inputString = remoteInput.getString(REPLY_KEY).toString()
            binding.tvNotification.text = inputString

            val channelId = "com.example.jetpacktutorial.notification.channel"
            val notificationId = 123

            val repliedNotification = NotificationCompat.Builder(this,channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentText("Your reply received")
                .build()

            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.notify(notificationId,repliedNotification)
        }
    }
}