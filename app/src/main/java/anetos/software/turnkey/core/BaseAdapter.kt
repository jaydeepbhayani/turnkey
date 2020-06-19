package anetos.software.turnkey.core

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/***
 *  created by jaydeepbhayani on 19/06/2020
 */
abstract class AbstractAdapter<ITEM> constructor(
    protected var itemList: List<ITEM>,
    private val layoutResId: Int
) : RecyclerView.Adapter<AbstractAdapter.Holder>() {
    override fun getItemCount() = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        val viewHolder = Holder(view)
        val itemView = viewHolder.itemView
        itemView.setOnClickListener {
            val adapterPosition = viewHolder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onItemClick(itemView, adapterPosition)
            }
        }
        return viewHolder
    }

    protected open fun onItemClick(itemView: View, position: Int) {
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        notifyDataSetChanged()
        holder.itemView.bind(item)
    }

    protected open fun View.bind(item: ITEM) {}

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

class BaseRecyclerViewAdapter<ITEM>(
    items: List<ITEM>,
    layoutResId: Int,
    private val bindHolder: View.(ITEM) -> Unit
) : AbstractAdapter<ITEM>(items, layoutResId) {

    private var itemClick: ITEM.() -> Unit = {}

    constructor(
        items: List<ITEM>,
        layoutResId: Int,
        bindHolder: View.(ITEM) -> Unit,
        itemClick: ITEM.() -> Unit = {}
    ) : this(items, layoutResId, bindHolder) {
        this.itemClick = itemClick
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.bindHolder(itemList[position])
    }

    override fun onItemClick(itemView: View, position: Int) {
        itemList[position].itemClick()
        this.notifyDataSetChanged()
    }
}

class SimpleDividerItemDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val mDivider: Drawable? =
        AppCompatResources.getDrawable(context, anetos.software.turnkey.R.drawable.line_divider)

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider!!.intrinsicHeight

            mDivider.setBounds(left+10, top, right-10, bottom)
            mDivider.draw(c)
        }
    }
}

fun <ITEM> RecyclerView.setup(
    items: List<ITEM>,
    layoutResId: Int,
    bindHolder: View.(ITEM) -> Unit,
    itemClick: ITEM.() -> Unit,
    manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)
): BaseRecyclerViewAdapter<ITEM> {
    return BaseRecyclerViewAdapter(items, layoutResId, {
        bindHolder(it)
    }, {
        itemClick()
    }).apply {
        layoutManager = manager
        adapter = this
        addItemDecoration(SimpleDividerItemDecoration(context))
    }
}
