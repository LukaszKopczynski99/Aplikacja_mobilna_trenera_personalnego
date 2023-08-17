package pl.kopczynski.praca_magisterska_amtp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

private lateinit var calc_zapotrzebowanie : Button
private lateinit var calc_BMI : Button
private lateinit var calc_woda : Button

class Dla_Mezczyzn_Kalkulatory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dla_mezczyzn_kalkulatory)

        calc_zapotrzebowanie = findViewById(R.id.button_dla_mezczyzn_kalk_zapotrzebowanie)
        calc_BMI = findViewById(R.id.button_dla_mezczyzn_kalk_BMI)
        calc_woda = findViewById(R.id.button_dla_mezczyzn_kalk_woda)

        calc_zapotrzebowanie.setOnClickListener(){
            Toast.makeText(this,"Kalkulator zapotrzebowania kalorycznego", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Kalkulator_zapotrzebowanie_mezczyzni::class.java)
            startActivity(intent)
        }

        calc_BMI.setOnClickListener(){
            Toast.makeText(this,"Kalkulator BMI", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,KalkulatorBMI_m::class.java)
            startActivity(intent)

        }

        calc_woda.setOnClickListener(){
            Toast.makeText(this,"Kalkulator zapotrzebowania na wodę", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Kalkulator_zapotrzebowanie_na_wode_m::class.java)
            startActivity(intent)
        }

    }
}