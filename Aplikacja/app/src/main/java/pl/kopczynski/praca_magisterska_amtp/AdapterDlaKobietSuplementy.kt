package pl.kopczynski.praca_magisterska_amtp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterDlaKobietSuplementy(private val exampleList: ArrayList<Suplementy>)
    : RecyclerView.Adapter<AdapterDlaKobietSuplementy.SuplementacjaViewHolder>() {


    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener : AdapterDlaKobietWiadomosci.OnItemClickListener {
        override fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuplementacjaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_suplementacja,
            parent, false
        )

        return SuplementacjaViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: SuplementacjaViewHolder, position: Int) {
        val currentItem = exampleList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
    }

    override fun getItemCount() = exampleList.size

    class SuplementacjaViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.kobiety_suplementacja_ikonka)
        val textView1: TextView = itemView.findViewById(R.id.kobiety_suplementacja_opis)
        init {

            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }

        }


    }
}