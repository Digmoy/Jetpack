package com.example.jetpacktutorial.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.databinding.DataBindingUtil
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityNotificationOneBinding

class NotificationOneActivity : AppCompatActivity(),View.OnClickListener{

    private lateinit var binding : ActivityNotificationOneBinding

    private val channelId = "com.example.jetpacktutorial.notification.channel"
    private var notificationManager : NotificationManager? = null
    private val REPLY_KEY = "reply_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_notification_one)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(channelId,"DemoChannel","this is a demo")
        binding.btnClick.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.btn_click ->{
                displayNotification()
            }
        }
    }

    private fun createNotificationChannel (id : String, name : String, channelDescription : String){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id,name,importance).apply {
                description = channelDescription
            }

            notificationManager?.createNotificationChannel(channel)
        }
    }

    private fun displayNotification() {
        val notificationId = 123

        val tapResultIntent = Intent(this,NotificationTwoActivity::class.java)
        val pendingIntent : PendingIntent = PendingIntent.getActivities(this,0,
            arrayOf(tapResultIntent),PendingIntent.FLAG_UPDATE_CURRENT)

        //reply action
        val remoteInput : RemoteInput = RemoteInput.Builder(REPLY_KEY).run {
            setLabel("")
            build()
        }

        val replyAction : NotificationCompat.Action = NotificationCompat.Action.Builder(
            0,
            "Reply",
            pendingIntent
        ).addRemoteInput(remoteInput).build()

        //action button
        val actionIntent = Intent(this,NotificationTwoActivity::class.java)
        val pendingIntent2 : PendingIntent = PendingIntent.getActivities(this,0,
            arrayOf(actionIntent),PendingIntent.FLAG_UPDATE_CURRENT)

        val action : NotificationCompat.Action = NotificationCompat.Action.Builder(0,"Details",pendingIntent2).build()

        val notification = NotificationCompat.Builder(this,channelId)
            .setContentTitle("Demo Title")
            .setContentText("This is a Demo Notification")
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
//            .setContentIntent(pendingIntent)
            .addAction(action)
            .addAction(replyAction)
            .build()

        notificationManager?.notify(notificationId,notification)
    }
}