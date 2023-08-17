package pl.kopczynski.praca_magisterska_amtp

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class Dla_Mezczyzn_Dzien_treningowy : AppCompatActivity(), TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener {

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
        setContentView(R.layout.activity_dla_mezczyzn_dzien_treningowy)

        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmIntent = PendingIntent.getBroadcast(applicationContext,0,
            Intent(applicationContext,AlarmReceiver::class.java),
            PendingIntent.FLAG_MUTABLE)

        TimeSetDate = findViewById(R.id.time_set_date_m)
        TimeSetHour = findViewById(R.id.time_set_hour_m)
        TimeSetAlarm = findViewById(R.id.time_set_alarm_m)
        TEXTTIME = findViewById(R.id.textTIME_m)

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
            Toast.makeText(this@Dla_Mezczyzn_Dzien_treningowy,"Alarm ustawiony pomyślnie", Toast.LENGTH_SHORT).show()
        }
    }
   override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        this.minute = minute
        this.hour = hourOfDay
    }
   override  fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        this.year = year
        this.month = month
        this.dayOfMonth = dayOfMonth
    }
}