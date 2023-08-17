package pl.kopczynski.praca_magisterska_amtp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Suplementacja_Dla_Kobiet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suplementacja_dla_kobiet)

        val Tytul : TextView = findViewById(R.id.Tekst_suplementacja_layout)
        val Opis : TextView = findViewById(R.id.Tres_suple_dla_kobiet)
        val Zdjecie : ImageView = findViewById(R.id.Suplementacja_dla_kobiet_zdjecie)

        val bundle : Bundle?=intent.extras
        val Tytul2 = bundle!!.getString("Tytul")
        val Opis2 = bundle.getString("Opis")
        val Zdjecie2 = bundle.getInt("ZdjecieId")


        Tytul.text = Tytul2
        Opis.text = Opis2
        Zdjecie.setImageResource(Zdjecie2)





    }
}