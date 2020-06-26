package anetos.software.turnkey.ui.home

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
import kotlinx.android.synthetic.main.item_nav_menu.view.title
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.view_dashboard_legend.view.*


class NavigationAdapter :
    RecyclerView.Adapter<NavigationAdapter.DrawerViewHolder>() {
    val TAG = javaClass.simpleName
    var itemArrayList: List<NaviMenuItem> = ArrayList()
    lateinit var context: Context

    var onItemClick: onItemclickListener? = null
    private var mListener: OnItemSelecteListener? = null

    fun setData(mContext: Context, setList: List<NaviMenuItem>) {
        itemArrayList = setList
        context = mContext
        notifyDataSetChanged()
        Log.d(TAG, "notified")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrawerViewHolder {
        val view: View
        if (viewType == TYPE_HEADER) {
            view =
                LayoutInflater.from(parent.context).inflate(R.layout.nav_header_main, parent, false)
        } else if (viewType == TYPE_BOTTOM) {
            view =
                LayoutInflater.from(parent.context).inflate(R.layout.nav_bottom_main, parent, false)
        } else {
            view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_nav_menu, parent, false)
        }

        return DrawerViewHolder(view, viewType)
    }


    override fun onBindViewHolder(holder: DrawerViewHolder, position: Int) {
        if (position == 0) {
            //holder.headerProfleImage.setImageResource(android.R.drawable.sym_def_app_icon)
            /*holder.ivLanguage.setOnClickListener {
                //(context as MainActivity).showLanguageDialog()
            }*/

            /*holder.tvRegister.setOnClickListener {
                val i = Intent(context, RegisterActivity::class.java)
                i.putExtra("nav_login", "register")
                context.startActivity(i)
                //startActivity(Intent(this, RegisterActivity::class.java))
            }*/
            //holder.headerTitle.text = "Android Developer"
            //holder.headerEmail.text = "yours@example.com"
        } else if (position == itemArrayList.size + 1)
        else {
            holder.title.text = context.getString(itemArrayList[position - 1].title)
            //holder.icon.setImageResource(itemArrayList[position - 1].icon)
        }
    }

    override fun getItemCount(): Int {
        Log.e("size", itemArrayList.size.toString())
        //return itemArrayList.size
        return itemArrayList.size + 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_HEADER
        } else if (position == itemArrayList.size + 1) TYPE_BOTTOM
        else TYPE_MENU

    }

    inner class DrawerViewHolder(itemView: View, viewType: Int) :
        RecyclerView.ViewHolder(itemView) {

        lateinit var headerProfleImage: ImageView
        lateinit var headerTitle: TextView
        lateinit var headerEmail: TextView
        lateinit var ivLanguage: ImageView
        lateinit var tvRegister: TextView
        lateinit var title: TextView
        lateinit var icon: ImageView

        init {

            if (viewType == 0) {
                tvRegister = itemView.tvRegister
            } else if (viewType == 2) {
            } else {
                title = itemView.title
                //icon = itemView.icon
            }

            itemView.setOnClickListener { view ->
                val pos = adapterPosition
                if (pos > 0) mListener!!.onItemSelected(view, pos - 1)
            }
        }
    }

    fun getData(): List<NaviMenuItem> {
        return itemArrayList
    }

    fun setOnItemClickLister(mListener: OnItemSelecteListener) {
        this.mListener = mListener
    }

    interface OnItemSelecteListener {
        fun onItemSelected(v: View, position: Int)
    }


    interface onItemclickListener {
        fun onItemClick(position: Int, data: BusinessDirectory)
    }

    fun setonItemClickListener(onItemclickListener: onItemclickListener) {
        this.onItemClick = onItemclickListener
    }

    companion object {
        val TYPE_HEADER = 0
        val TYPE_MENU = 1
        val TYPE_BOTTOM = 2
    }
}