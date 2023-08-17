package pl.kopczynski.praca_magisterska_amtp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

private lateinit var pkPlany:Button
private lateinit var pkDiety:Button
private lateinit var pkSuple:Button
private lateinit var pkKalku:Button
private lateinit var pkNews:Button
private lateinit var pkKalen:Button


class Sekcja_dla_kobiet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sekcja_dla_kobiet)

        pkPlany = findViewById(R.id.przycisk_Dla_kobiet_plany_treningowe)
        pkDiety = findViewById(R.id.przycisk_Dla_kobiet_diety)
        pkSuple = findViewById(R.id.przycisk_Dla_kobiet_suplementacja)
        pkKalku = findViewById(R.id.przycisk_Dla_kobiet_kalkulatory_sportowe)
        pkNews = findViewById(R.id.przycisk_Dla_kobiet_wiadomości)
        pkKalen = findViewById(R.id.przycisk_Dla_kobiet_Kalendarz_treningowy)

        pkPlany.setOnClickListener(){
            Toast.makeText(this,"Plany Treningowe", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dla_Kobiet_Plany_Treningowe::class.java)
            startActivity(intent)
        }

        pkDiety.setOnClickListener(){
            Toast.makeText(this,"Diety", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dla_Kobiet_Diety::class.java)
            startActivity(intent)
        }

        pkSuple.setOnClickListener(){
            Toast.makeText(this,"Suplementacja", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dla_Kobiet_Suplementacja::class.java)
            startActivity(intent)
        }

        pkKalku.setOnClickListener(){
            Toast.makeText(this,"Kalkulatory sportowe", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dla_Kobiet_Kalkulatory::class.java)
            startActivity(intent)
        }

        pkNews.setOnClickListener(){
            Toast.makeText(this,"Wiadomości", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dla_Kobiet_Wiadomosci::class.java)
            startActivity(intent)
        }

        pkKalen.setOnClickListener(){
            Toast.makeText(this,"Dzień treningowy", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dla_Kobiet_Kalendarz::class.java)
            startActivity(intent)

        }




    }
}