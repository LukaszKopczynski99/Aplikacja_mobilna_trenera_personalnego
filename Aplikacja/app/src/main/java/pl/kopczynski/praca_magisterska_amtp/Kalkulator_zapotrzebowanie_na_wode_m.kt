package pl.kopczynski.praca_magisterska_amtp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Kalkulator_zapotrzebowanie_na_wode_m : AppCompatActivity() {

    private lateinit var EditTextWaga : EditText
    private lateinit var ButtonOblicz : Button
    private lateinit var TextViewWyswietl_liczba : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_zapotrzebowanie_na_wode_m)

        EditTextWaga = findViewById(R.id.Waga_kalkulator_zapotrzebowanie_woda_m)
        ButtonOblicz = findViewById(R.id.Kalkulator_zapotrzebowanie_oblicz_woda_m)
        TextViewWyswietl_liczba = findViewById(R.id.Kalkulator_zapotrzebowanie_woda_WYNIK_liczba_m)

        ButtonOblicz.setOnClickListener(){
            val Waga = EditTextWaga.text.toString()

            if(PustePole(Waga))
            {
                val woda = 30 * Waga.toFloat()

                val zaporzebowanie2Digits = String.format("%.2f",woda).toFloat()
                TextViewWyswietl_liczba.text = zaporzebowanie2Digits.toString()
            }


        }

    }

    private fun PustePole(Waga:String?):Boolean{
        return when{
            Waga.isNullOrEmpty() -> {
                Toast.makeText(this,"Podaj wagę", Toast.LENGTH_SHORT).show()
                return false
            }
            else -> {
                return true
            }

        }
    }

}