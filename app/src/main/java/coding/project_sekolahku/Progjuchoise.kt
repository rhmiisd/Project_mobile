package coding.project_sekolahku

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Progjuchoise(var pList: List<dataprogju>) :
    RecyclerView.Adapter<Progjuchoise.progjuViewHolder>() {

    inner class progjuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTv : TextView = itemView.findViewById(R.id.titleTv)
    }

    fun setFilteredList(pList: ArrayList<dataprogju>){
        this.pList = pList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): progjuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_itemprogju , parent , false)
        return progjuViewHolder(view)
    }

    override fun onBindViewHolder(holder: progjuViewHolder, position: Int) {
        holder.titleTv.text = pList[position].title
    }

    override fun getItemCount(): Int {
        return pList.size
    }
}