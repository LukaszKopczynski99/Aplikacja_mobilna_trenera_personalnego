package pl.kopczynski.praca_magisterska_amtp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dla_Mezczyzn_wiadomosci : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Wiadomosci>
    lateinit var imageId : Array<Int>
    lateinit var Tytul : Array<String>
    lateinit var Opis : Array<String>
    lateinit var Zdjecie : Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dla_mezczyzn_wiadomosci)
        imageId = arrayOf(
            R.drawable.baseline_info_24,
            R.drawable.baseline_info_24,
            R.drawable.baseline_info_24,
            R.drawable.baseline_info_24,
            R.drawable.baseline_info_24,
            R.drawable.baseline_info_24,
            R.drawable.baseline_info_24,
            R.drawable.baseline_info_24
        )

        Tytul = arrayOf(
            "Rekordowo i premierowo. Największe w Polsce Targi Fitness i Sportów Siłowych",
            "Kettlebell trening. Jakie efekty przynoszą ćwiczenia z kettlebell?",
            "Trening na czczo. Czy trening na czczo jest dobry? Ile powinien trwać trening?",
            "Mięśnie brzucha - wzmocnij je od wewnątrz!",
            "Nie daj się rutynie! Zmieniaj system treningowy!",
            "Bieganie zimą. Jak się odpowiednio ubrać?",
            "Jak znaleźć czas na aktywność? 5 skutecznych sposobów",
            "Najprzyjemniejsze i najszybsze 5km w Poznaniu!"
        )

        Opis = arrayOf(
            getString(R.string.news_1),
            getString(R.string.news_2),
            getString(R.string.news_3),
            getString(R.string.news_4),
            getString(R.string.news_5),
            getString(R.string.news_6),
            getString(R.string.news_7),
            getString(R.string.news_8)
        )

        Zdjecie = arrayOf(
            R.drawable.zdjecie_wiadomosci_targi,
            R.drawable.zdjecie_wiadomosci_ketle,
            R.drawable.zdjecie_wiadomosci_naczczo,
            R.drawable.zdjecie_wiadomosci_brzuch,
            R.drawable.zdjecie_wiadomosci_rutyna,
            R.drawable.zdjecie_wiadomosci_zima,
            R.drawable.zdjecie_wiadomosci_rower,
            R.drawable.zdjecie_wiadomosci_bieg
        )

        newRecyclerView = findViewById(R.id.recycler_view_dla_mezczyzn_wiadomosci)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Wiadomosci>()
        gerUserdata()
    }

    private fun gerUserdata() {

        for (i in imageId.indices){
            val temp = Wiadomosci(imageId[i],Tytul[i])
            newArrayList.add(temp)
        }
        var adapter = AdapterDlaKobietWiadomosci(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : AdapterDlaKobietSuplementy.OnItemClickListener{
            override fun onItemClick(position: Int) {

                val intent = Intent(this@Dla_Mezczyzn_wiadomosci,MainActivity3::class.java)
                intent.putExtra("Tytul",newArrayList[position].text1)
                intent.putExtra("ZdjecieId",Zdjecie[position])
                intent.putExtra("Opis",Opis[position])
                startActivity(intent)

            }

        })

    }
}