package coding.project_sekolahku

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class schoolchoise(var mList: List<dataschool>) :
    RecyclerView.Adapter<schoolchoise.schoolViewHolder>() {

    inner class schoolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logo : ImageView = itemView.findViewById(R.id.logoIv)
        val titleTv : TextView = itemView.findViewById(R.id.titleTv)
    }

    fun setFilteredList(mList: ArrayList<dataschool>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): schoolViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_itemschool , parent , false)
        return schoolViewHolder(view)
    }

    override fun onBindViewHolder(holder: schoolViewHolder, position: Int) {
        holder.logo.setImageResource(mList[position].logo)
        holder.titleTv.text = mList[position].title
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}