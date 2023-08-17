package pl.kopczynski.praca_magisterska_amtp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dla_Kobiet_Plany_Treningowe : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Plan>
    lateinit var imageId : Array<Int>
    lateinit var Tytul : Array<String>
    lateinit var Trening : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dla_kobiet_plany_treningowe)

        imageId = arrayOf(
            R.drawable.body,
            R.drawable.shoulder2,
            R.drawable.back,
            R.drawable.muscle,
            R.drawable.triceps,
            R.drawable.leg,
            R.drawable.belly2,
            R.drawable.cardio
        )

        Tytul = arrayOf(
            "Klatka piersiowa",
            "Barki",
            "Plecy",
            "Dwuglowy ramienia",
            "Trójgłowy ramienia",
            "Nogi",
            "Brzuch",
            "Cardio"
        )

        Trening = arrayOf(

            getString(R.string.kobiety_klatka_piersiowa),
            getString(R.string.kobiety_barki),
            getString(R.string.kobiety_plecy),
            getString(R.string.kobiety_biceps),
            getString(R.string.kobiety_triceps),
            getString(R.string.kobiety_nogi),
            getString(R.string.kobiety_brzuch),
            getString(R.string.kobiety_cardio)

        )

        newRecyclerView = findViewById(R.id.Recycler_viev_dla_kobiet_plany_treningowe)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)


        newArrayList = arrayListOf<Plan>()
        gerUserdata()
    }

    private fun gerUserdata() {

        for (i in imageId.indices){
            val temp = Plan(imageId[i],Tytul[i])
            newArrayList.add(temp)
        }

        var adapter = AdapterDlaKobietPlan(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object :AdapterDlaKobietPlan.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@Dla_Kobiet_Plany_Treningowe,Plan_Dla_Kobiet::class.java)
                intent.putExtra("heading",newArrayList[position].heading)
                intent.putExtra("Trening",Trening[position])
                startActivity(intent)
            }


        })

    }
}