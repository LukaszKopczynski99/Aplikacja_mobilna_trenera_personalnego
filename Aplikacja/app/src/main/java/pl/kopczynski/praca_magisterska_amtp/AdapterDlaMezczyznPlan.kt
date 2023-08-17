package pl.kopczynski.praca_magisterska_amtp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView


class AdapterDlaMezczyznPlan(private val newList: ArrayList<Plan>) :
    RecyclerView.Adapter<AdapterDlaMezczyznPlan.MyViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_dla_mezczyzn_plany_treningowe, parent, false)

        return MyViewHolder(itemView,mListener)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = newList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.Tytul.text=currentItem.heading

    }

    class MyViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.image_dla_mezczyzn_plany_treningowe)
        val Tytul : TextView = itemView.findViewById(R.id.Tytuł_dla_mezczyzn_plany_treningowe)
        init {

            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }

        }


    }
}