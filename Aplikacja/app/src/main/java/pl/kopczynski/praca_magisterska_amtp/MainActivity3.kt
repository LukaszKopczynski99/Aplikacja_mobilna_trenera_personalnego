package pl.kopczynski.praca_magisterska_amtp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val Tytul : TextView = findViewById(R.id.Tytul_wiadomosci_layout_m)
        val Opis : TextView = findViewById(R.id.Tresc_wiadomosci_dla_kobiet_layout_m)
        val Zdjecie : ImageView = findViewById(R.id.Wiadomosci_dla_kobiet_zdjecie_m)

        val bundle : Bundle?=intent.extras
        val Tytul2 = bundle!!.getString("Tytul")
        val Opis2 = bundle.getString("Opis")
        val Zdjecie2 = bundle.getInt("ZdjecieId")


        Tytul.text = Tytul2
        Opis.text = Opis2
        Zdjecie.setImageResource(Zdjecie2)

    }
}