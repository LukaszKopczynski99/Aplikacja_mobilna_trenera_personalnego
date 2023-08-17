package pl.kopczynski.praca_magisterska_amtp

import android.annotation.TargetApi
import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import pl.kopczynski.praca_magisterska_amtp.databinding.ActivityMainBinding
import java.time.MonthDay
import java.util.*

class Dla_Kobiet_Kalendarz : AppCompatActivity(), OnTimeSetListener,OnDateSetListener {

    private lateinit var TimeSetDate: Button
    private lateinit var TimeSetHour: Button
    private lateinit var TimeSetAlarm: Button
    private lateinit var TEXTTIME : TextView

    private var minute = 0
    private var hour = 0
    private var dayOfMonth = 0
    private var month = 0
    private var year = 0

    lateinit var alarmManager: AlarmManager
    lateinit var alarmIntent: PendingIntent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dla_kobiet_kalendarz)

        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmIntent = PendingIntent.getBroadcast(applicationContext,0,Intent(applicationContext,AlarmReceiver::class.java),PendingIntent.FLAG_MUTABLE)

        TimeSetDate = findViewById(R.id.time_set_date)
        TimeSetHour = findViewById(R.id.time_set_hour)
        TimeSetAlarm = findViewById(R.id.time_set_alarm)
        TEXTTIME = findViewById(R.id.textTIME)

        TimeSetHour.setOnClickListener {
            val dialog = MyTimePickerDialog()
            dialog.show(supportFragmentManager,"time_picker")
        }
        TimeSetDate.setOnClickListener {
            val dialog = MyDatePickerDialog()
            dialog.show(supportFragmentManager,"date_picker")
        }
        TimeSetAlarm.setOnClickListener {


            val date = Calendar.Builder()
                .setDate(year, month, dayOfMonth)
                .setTimeOfDay(hour,minute,0)
                .build()

            alarmManager.set(AlarmManager.RTC_WAKEUP,date.time.time, alarmIntent)
            TEXTTIME.text = "$year-${month+1}-$dayOfMonth//$hour:$minute"
            Toast.makeText(this@Dla_Kobiet_Kalendarz,"Alarm ustawiony pomyślnie",Toast.LENGTH_SHORT).show()
        }



    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        this.minute = minute
        this.hour = hourOfDay

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        this.year = year
        this.month = month
        this.dayOfMonth = dayOfMonth
    }
}