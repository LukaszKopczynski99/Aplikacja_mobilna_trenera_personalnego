package pl.kopczynski.praca_magisterska_amtp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Kalkulator_zapotrzebowanie_mezczyzni : AppCompatActivity() {
    private lateinit var EditTextWaga : EditText
    private lateinit var EditTextWzrost : EditText
    private lateinit var EditTextWiek : EditText
    private lateinit var ButtonOblicz : Button
    private lateinit var TextViewWyswietl_liczba : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_zapotrzebowanie_mezczyzni)
        EditTextWaga = findViewById(R.id.Waga_kalkulator_zapotrzebowanie_m)
        EditTextWzrost = findViewById(R.id.Wzrost_kalkulator_zapotrzebowanie_m)
        EditTextWiek = findViewById(R.id.Wiek_kalkulator_zapotrzebowanie_m)
        ButtonOblicz = findViewById(R.id.Kalkulator_zapotrzebowanie_oblicz_m)
        TextViewWyswietl_liczba = findViewById(R.id.Kalkulator_zapotrzebowanie_WYNIK_liczba_m)

        ButtonOblicz.setOnClickListener(){
            val Wzrost = EditTextWzrost.text.toString()
            val Waga = EditTextWaga.text.toString()
            val Wiek = EditTextWiek.text.toString()

            if(PustePole(Wzrost, Waga, Wiek))
            {
                val zapotrzebowanie = 10 * Waga.toFloat() + 6.25 *
                        Wzrost.toFloat() - 5 * Wiek.toFloat() +5

                val zaporzebowanie2Digits = String.format("%.2f",zapotrzebowanie).toFloat()

                TextViewWyswietl_liczba.text = zaporzebowanie2Digits.toString()
            }


        }

    }
    private fun PustePole(Wzrost:String?,Waga:String?,Wiek:String?):Boolean{
        return when{
            Waga.isNullOrEmpty() -> {
                Toast.makeText(this,"Podaj wagę",
                    Toast.LENGTH_SHORT).show()
                return false
            }
            Wzrost.isNullOrEmpty() -> {
                Toast.makeText(this,"Podaj wzrost",
                    Toast.LENGTH_SHORT).show()
                return false
            }
            Wiek.isNullOrEmpty() -> {
                Toast.makeText(this,"Podaj wiek",
                    Toast.LENGTH_SHORT).show()
                return false
            }
            else -> {
                return true
            }

        }
    }


}