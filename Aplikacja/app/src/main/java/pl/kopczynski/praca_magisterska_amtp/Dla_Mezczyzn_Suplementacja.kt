package pl.kopczynski.praca_magisterska_amtp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Dla_Mezczyzn_Suplementacja : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Suplementy>
    lateinit var imageId : Array<Int>
    lateinit var Tytul : Array<String>
    lateinit var Opis : Array<String>
    lateinit var Zdjecie : Array<Int>

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_dla_mezczyzn_suplementacja)
            imageId = arrayOf(
                R.drawable.baseline_health_and_safety_24,
                R.drawable.baseline_health_and_safety_24,
                R.drawable.baseline_health_and_safety_24,
                R.drawable.baseline_health_and_safety_24,

                )

            Tytul = arrayOf(
                "Kreatyna",
                "Białko",
                "Witaminy i minerały",
                "Omega-3"
            )

            Opis = arrayOf(
                getString(R.string.kreatyna_opis),
                getString(R.string.bialko_opis),
                getString(R.string.Witaminy_opis),
                getString(R.string.Omega_opis)
            )

            Zdjecie = arrayOf(
                R.drawable.krea_foto_lepsze,
                R.drawable.bialko_foto,
                R.drawable.witaminy_foto,
                R.drawable.omega_foto
            )


            newRecyclerView = findViewById(R.id.Recycler_view_dla_mezczyzn_suplementacja)
            newRecyclerView.layoutManager = LinearLayoutManager(this)
            newRecyclerView.setHasFixedSize(true)

            newArrayList = arrayListOf<Suplementy>()
            gerUserdata()

        }


        private fun gerUserdata() {

            for (i in imageId.indices){
                val temp = Suplementy(imageId[i],Tytul[i])
                newArrayList.add(temp)
            }

            var adapter = AdapterDlaMezczyznSuplementy(newArrayList)
            newRecyclerView.adapter = adapter
            adapter.setOnItemClickListener(object :AdapterDlaMezczyznSuplementy.OnItemClickListener{
                override fun onItemClick(position: Int) {

                    val intent = Intent(this@Dla_Mezczyzn_Suplementacja,Suplementacja_Dla_Mezczyzn::class.java)
                    intent.putExtra("Tytul",newArrayList[position].text1)
                    intent.putExtra("ZdjecieId",Zdjecie[position])
                    intent.putExtra("Opis",Opis[position])
                    startActivity(intent)
                }

            })

        }
    }