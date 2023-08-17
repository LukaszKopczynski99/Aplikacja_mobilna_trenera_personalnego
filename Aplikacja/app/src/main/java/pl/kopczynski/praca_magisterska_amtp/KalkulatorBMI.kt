package pl.kopczynski.praca_magisterska_amtp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class KalkulatorBMI : AppCompatActivity() {

    private lateinit var EditTextWaga : EditText
    private lateinit var EditTextWzrost : EditText
    private lateinit var ButtonOblicz : Button
    private lateinit var TextViewWyswietl_liczba : TextView
    private lateinit var TextViewWyswietl_slowo : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_bmi)

        EditTextWaga = findViewById(R.id.Waga_kalkulator_Bmi)
        EditTextWzrost = findViewById(R.id.Wzrost_kalkulator_Bmi)
        ButtonOblicz = findViewById(R.id.Kalkulator_BMI_oblicz)
        TextViewWyswietl_liczba = findViewById(R.id.Kalkulator_BMI_WYNIK_liczba)
        TextViewWyswietl_slowo = findViewById(R.id.Kalkulator_BMI_WYNIK_slowo)




        ButtonOblicz.setOnClickListener(){
            val Wzrost = EditTextWzrost.text.toString()
            val Waga = EditTextWaga.text.toString()

            if(PustePole(Wzrost,Waga))
            {
                val bmi = Waga.toFloat()/((Wzrost.toFloat()/100)*(Wzrost.toFloat()/100))

                val bmi2Digirs = String.format("%.2f",bmi).toFloat()
                Wystietl(bmi2Digirs)
            }


        }


    }

    private fun PustePole(Wzrost:String?,Waga:String?):Boolean{
        return when{
            Waga.isNullOrEmpty() -> {
                Toast.makeText(this,"Podaj wagę",Toast.LENGTH_SHORT).show()
                return false
            }
            Wzrost.isNullOrEmpty() -> {
                Toast.makeText(this,"Podaj wzrost",Toast.LENGTH_SHORT).show()
                return false
            }
            else -> {
                return true
            }

        }
    }


    private fun Wystietl (bmi: Float){

        TextViewWyswietl_liczba.text = bmi.toString()

        var resulttext = ""

        when{
            bmi<16.00 -> {
                resulttext = "Wygłodzenie"
            }
            bmi in 16.00 .. 16.99 -> {
                resulttext = "Wychudzenie"
            }
            bmi in 17.00 .. 18.49 -> {
                resulttext = "Niedowaga"
            }
            bmi in 18.50 .. 24.99 -> {
                resulttext = "Waga prawidłowa"
            }
            bmi in 25.00 .. 29.99 -> {
                resulttext = "Nadwaga"
            }
            bmi in 30.00 ..34.99  -> {
                resulttext = "Otyłość 1 st."
            }
            bmi in 35.00 ..39.99  -> {
                resulttext = "Otyłość 2 st."
            }
            bmi > 40 -> {
                resulttext = "Otyłość 3 st."
            }
        }
        TextViewWyswietl_slowo.text = resulttext

    }


}