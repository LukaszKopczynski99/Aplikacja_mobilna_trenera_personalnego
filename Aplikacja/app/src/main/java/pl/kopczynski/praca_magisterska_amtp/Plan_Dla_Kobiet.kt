package pl.kopczynski.praca_magisterska_amtp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Plan_Dla_Kobiet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_dla_kobiet)

        val Tytul : TextView = findViewById(R.id.T_Plan_dla_kobiet_rodzaj_treningu)
        val Tresc : TextView = findViewById(R.id.Tresc_Plan_dla_kobiet_rodzaj_treningu)

        val bundle : Bundle?= intent.extras
        val heading = bundle!!.getString("heading")
        val Trening = bundle.getString("Trening")

        Tytul.text = heading
        Tresc.text = Trening
    }
}