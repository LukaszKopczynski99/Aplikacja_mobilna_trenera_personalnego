package pl.kopczynski.praca_magisterska_amtp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.net.Uri


private lateinit var Przycisk_przepisy : Button
private lateinit var Przycisk_zapo : Button


class Dla_Kobiet_Diety : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dla_kobiet_diety)


        Przycisk_przepisy = findViewById(R.id.button_dla_kobiet_diety_przepisy)
        Przycisk_zapo = findViewById(R.id.button_dla_kobiet_diety_zapotrzebowaniekal)

        Przycisk_przepisy.setOnClickListener(){
            Toast.makeText(this,"Przepisy", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dla_Kobiet_Diety_Przepisy::class.java)
            startActivity(intent)
        }

        Przycisk_zapo.setOnClickListener(){
            Toast.makeText(this,"Makroskładniki", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.maczfit.pl/blog/makroskladniki-czym-sa-jak-je-obliczyc/"))
            startActivity(intent)
        }
    }
}