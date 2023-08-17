package pl.kopczynski.praca_magisterska_amtp

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver : BroadcastReceiver() {

    companion object{
        const val ID = "CHANNEL_ID"
        const val channelName = "CHANNEL_NAME"
    }


    override fun onReceive(context: Context?, intent: Intent?) {

        val manager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        val channelNotification: NotificationCompat.Builder =
            NotificationCompat.Builder(context, ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Trener Personalny")
            .setContentText("Czas na trening")
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        val channel = NotificationChannel(ID, channelName,NotificationManager.IMPORTANCE_HIGH)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            manager.createNotificationChannel(channel)
            manager.notify(1,channelNotification.build())
        }

    }
}