package anetos.software.turnkey.ui.common

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import anetos.software.turnkey.R
import anetos.software.turnkey.data.model.BusinessDirectory
import anetos.software.turnkey.data.model.NaviMenuItem


class CategoryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val TAG = javaClass.simpleName
    var itemArrayList: List<NaviMenuItem> = ArrayList()
    lateinit var context: Context

    var onItemClick: onItemclickListener? = null

    fun setData(mContext: Context, setList: List<NaviMenuItem>) {
        itemArrayList = setList
        context = mContext
        notifyDataSetChanged()
        Log.d(TAG, "notified")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = itemArrayList.get(position)
        (holder as CategoryViewHolder).tvTitle.text = context.getString(data.title)
        holder.ivPhoto.setImageResource(data.icon)
        //Picasso.get().load(data.menu_image).into(holder.ivLogo)
        //Glide.with(context).load("")into(holder.ivPhoto)
    }

    override fun getItemCount(): Int {
        Log.e("size", itemArrayList.size.toString())
        return itemArrayList.size
    }


    private inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivPhoto: ImageView
        var tvTitle: TextView

        init {
            ivPhoto = itemView.findViewById(R.id.ivPhoto)
            tvTitle = itemView.findViewById(R.id.tvTitle)
        }
    }

    fun getData(): List<NaviMenuItem> {
        return itemArrayList
    }

    interface onItemclickListener {
        fun onItemClick(position: Int, data: BusinessDirectory)
    }

    fun setonItemClickListener(onItemclickListener: onItemclickListener) {
        this.onItemClick = onItemclickListener
    }
}