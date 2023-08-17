package pl.kopczynski.praca_magisterska_amtp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterDlaMezczyznWiadomosci(private val exampleList: ArrayList<Wiadomosci>)
    : RecyclerView.Adapter<AdapterDlaMezczyznWiadomosci.WiadomosciViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: AdapterDlaMezczyznSuplementy.OnItemClickListener){
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WiadomosciViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_wiadomosci,
            parent, false)

        return WiadomosciViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: WiadomosciViewHolder, position: Int) {
        val currentItem = exampleList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
    }

    override fun getItemCount() = exampleList.size

    class WiadomosciViewHolder(itemView: View, listener : OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.kobiety_wiadomosci_ikonka)
        val textView1: TextView =itemView.findViewById(R.id.kobiety_wiadomosci_opis)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }


    }



}