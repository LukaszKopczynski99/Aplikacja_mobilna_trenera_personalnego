package pl.kopczynski.praca_magisterska_amtp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

private lateinit var pk: Button
private lateinit var pm:Button


class Wybor_mezczyzna_kobieta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wybor_mezczyzna_kobieta)

        pm = findViewById(R.id.Przycisk_dla_mężczyzn)
        pk = findViewById(R.id.Przycisk_dla_kobiet)

        pm.setOnClickListener(){
            Toast.makeText(this,"Sekcja dla mężczyzn", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,sekcja_dla_mezczyzn::class.java)
            startActivity(intent)
        }

        pk.setOnClickListener(){
            Toast.makeText(this,"Sekcja dla kobiet", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Sekcja_dla_kobiet::class.java)
            startActivity(intent)
        }


    }
}