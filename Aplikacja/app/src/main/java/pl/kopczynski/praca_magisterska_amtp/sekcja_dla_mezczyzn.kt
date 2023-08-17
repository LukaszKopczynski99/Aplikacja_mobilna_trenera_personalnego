package pl.kopczynski.praca_magisterska_amtp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

private lateinit var pkPlany: Button
private lateinit var pkDiety: Button
private lateinit var pkSuple: Button
private lateinit var pkKalku: Button
private lateinit var pkNews: Button
private lateinit var pkKalen: Button


class sekcja_dla_mezczyzn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sekcja_dla_mezczyzn)

        pkPlany = findViewById(R.id.przycisk_Dla_mezczyzn_plany_treningowe)
        pkDiety = findViewById(R.id.przycisk_Dla_mezczyzn_diety)
        pkSuple = findViewById(R.id.przycisk_Dla_mezczyzn_suplementacja)
        pkKalku = findViewById(R.id.przycisk_Dla_mezczyzn_kalkulatory_sportowe)
        pkNews = findViewById( R.id.przycisk_Dla_mezczyzn_wiadomości)
        pkKalen = findViewById(R.id.przycisk_Dla_mezczyzn_Kalendarz_treningowy)

        pkPlany.setOnClickListener(){
            Toast.makeText(this,"Plany Treningowe", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dla_Mezczyzn_Plany_Treningowe::class.java)
            startActivity(intent)
        }

        pkDiety.setOnClickListener(){
            Toast.makeText(this,"Diety", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dla_Mezczyzn_Diety::class.java)
            startActivity(intent)
        }

        pkSuple.setOnClickListener(){
            Toast.makeText(this,"Suplementacja", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dla_Mezczyzn_Suplementacja::class.java)
            startActivity(intent)
        }

        pkKalku.setOnClickListener(){
            Toast.makeText(this,"Kalkulatory sportowe", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dla_Mezczyzn_Kalkulatory::class.java)
            startActivity(intent)
        }

        pkNews.setOnClickListener(){
            Toast.makeText(this,"Wiadomości", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dla_Mezczyzn_wiadomosci::class.java)
            startActivity(intent)
        }

        pkKalen.setOnClickListener(){
            Toast.makeText(this,"Dzień treningowy", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dla_Mezczyzn_Dzien_treningowy::class.java)
            startActivity(intent)

        }

    }
}