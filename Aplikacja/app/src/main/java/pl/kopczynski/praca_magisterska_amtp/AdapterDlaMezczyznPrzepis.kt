package pl.kopczynski.praca_magisterska_amtp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterDlaMezczyznPrzepis(private val exampleList: List<Przepis>)
    : RecyclerView.Adapter<AdapterDlaMezczyznPrzepis.PrzepisViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrzepisViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list_przepisy,
            parent, false
        )

        return PrzepisViewHolder(itemView,mListener)
    }


    override fun onBindViewHolder(holder: PrzepisViewHolder, position: Int) {

        val currentItem = exampleList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
    }


    override fun getItemCount()= exampleList.size

    class PrzepisViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.kobiety_przepisy_ikonka)
        val textView1: TextView = itemView.findViewById(R.id.kobiety_przepisy_opis)
        init {

            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }

        }
    }
}



