package pl.kopczynski.praca_magisterska_amtp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dla_Mezczyzn_Diety_Przepisy : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Przepis>
    lateinit var imageId : Array<Int>
    lateinit var Tytul : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dla_mezczyzn_diety_przepisy)
        imageId = arrayOf(
            R.drawable.baseline_food_bank_24,
            R.drawable.baseline_food_bank_24,
            R.drawable.baseline_food_bank_24,
            R.drawable.baseline_food_bank_24,
            R.drawable.baseline_food_bank_24,
            R.drawable.baseline_food_bank_24,
            R.drawable.baseline_food_bank_24,
            R.drawable.baseline_food_bank_24,
            R.drawable.baseline_food_bank_24,
            R.drawable.baseline_food_bank_24

        )

        Tytul = arrayOf(
            "Makaron w pesto w stylu śródziemnomorskim",
            "Makaron spaghetti z parmezanem w pomidorach",
            "Makaron z łososiem wędzonym i szpinakiem",
            "Deser w stylu tiramisu z nieziemsko dobrym makro!",
            "Burger z buraka",
            "Jajecznica",
            "Owsianka",
            "Omlet",
            "Skyr waniliowy – kiedy nie ma w sklepie",
            "Wytrawna tarta z kurkami"

        )

        newRecyclerView = findViewById(R.id.Recycler_view_dla_mezczyzn_diety_przepisy)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)


        newArrayList = arrayListOf<Przepis>()
        gerUserdata()
    }

    private fun gerUserdata() {

        for (i in imageId.indices){
            val temp = Przepis(imageId[i],Tytul[i])
            newArrayList.add(temp)
        }

        var adapter = AdapterDlaKobietPrzepis(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : AdapterDlaKobietPrzepis.OnItemClickListener{
            override fun onItemClick(position: Int) {
                if (position == 0 )
                {
                    Toast.makeText(this@Dla_Mezczyzn_Diety_Przepisy, "Makaron w pesto w stylu śródziemnomorskim", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://dieta-sportowca.pl/2022/01/szybkie-przepisy-na-makaron-dla-sportowca/"))
                    startActivity(intent)
                }
                if (position == 1 )
                {
                    Toast.makeText(this@Dla_Mezczyzn_Diety_Przepisy, "Makaron spaghetti z parmezanem w pomidorach", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://dieta-sportowca.pl/2022/01/szybkie-przepisy-na-makaron-dla-sportowca/"))
                    startActivity(intent)
                }
                if (position == 2 )
                {
                    Toast.makeText(this@Dla_Mezczyzn_Diety_Przepisy, "Makaron z łososiem wędzonym i szpinakiem", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://dieta-sportowca.pl/2022/01/szybkie-przepisy-na-makaron-dla-sportowca/"))
                    startActivity(intent)
                }
                if (position == 3 )
                {
                    Toast.makeText(this@Dla_Mezczyzn_Diety_Przepisy, "Deser w stylu tiramisu z nieziemsko dobrym makro!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://dieta-sportowca.pl/2022/04/domowe-tiramisu/"))
                    startActivity(intent)
                }
                if (position == 4 )
                {
                    Toast.makeText(this@Dla_Mezczyzn_Diety_Przepisy, "Burger z buraka", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://dieta-sportowca.pl/2021/05/jak-suplementowac-azotany-posilki-bogate-w-azotany-cz-2/"))
                    startActivity(intent)
                }
                if (position == 5 )
                {
                    Toast.makeText(this@Dla_Mezczyzn_Diety_Przepisy, "Jajecznica", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://dieta-sportowca.pl/2020/10/jajecznica-z-warzywami-i-szakszuka-z-tofu-jak-zrobic/"))
                    startActivity(intent)
                }
                if (position == 6 )
                {
                    Toast.makeText(this@Dla_Mezczyzn_Diety_Przepisy, "Owsianka", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://dieta-sportowca.pl/2020/09/przepisy-na-szybkie-sniadania-owsianka-i-omlet/"))
                    startActivity(intent)
                }
                if (position == 7 )
                {
                    Toast.makeText(this@Dla_Mezczyzn_Diety_Przepisy,  "Omlet", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://dieta-sportowca.pl/2020/09/przepisy-na-szybkie-sniadania-owsianka-i-omlet/"))
                    startActivity(intent)
                }
                if (position == 8 )
                {
                    Toast.makeText(this@Dla_Mezczyzn_Diety_Przepisy, "Skyr waniliowy – kiedy nie ma w sklepie", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://dieta-sportowca.pl/2019/08/domowy-skyr-owocowy-i-waniliowy-przepis-w-3-minuty/"))
                    startActivity(intent)
                }
                if (position == 9 )
                {
                    Toast.makeText(this@Dla_Mezczyzn_Diety_Przepisy, "Wytrawna tarta z kurkami", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://dieta-sportowca.pl/2019/08/wytrawne-tarty-dla-aktywnych-ktore-pokochasz-niskotluszczowe-wegetarianskie/"))
                    startActivity(intent)
                }
            }

        })


    }



}