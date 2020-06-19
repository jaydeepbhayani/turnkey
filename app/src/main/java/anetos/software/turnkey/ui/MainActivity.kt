package anetos.software.turnkey.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import anetos.software.turnkey.R
import anetos.software.turnkey.data.model.BusinessDirectory
import anetos.software.turnkey.data.model.NaviMenuItem
import anetos.software.turnkey.ui.common.CategoryAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  created by jaydeepbhayani on 19/06/2020
 */

class MainActivity : AppCompatActivity() {

    val categoryItemList = arrayListOf(
        NaviMenuItem(
            icon = R.drawable.kitchen,
            title = R.string.menu_modular_kitchen
        ), NaviMenuItem(
            icon = R.drawable.wardrobes1,
            title = R.string.menu_wardrobes
        ), NaviMenuItem(
            icon = R.drawable.sofa1,
            title = R.string.menu_sofas
        ), NaviMenuItem(
            icon = R.drawable.diningtable,
            title = R.string.menu_dining_tables
        ), NaviMenuItem(
            icon = R.drawable.curtains,
            title = R.string.menu_curtains
        ), NaviMenuItem(
            icon = R.drawable.lights,
            title = R.string.menu_lights
        ), NaviMenuItem(
            icon = R.drawable.aluminiumwindows,
            title = R.string.menu_alluminium_windows
        )
    )

    lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAdapter()
    }

    private fun setAdapter() {
        categoryAdapter = CategoryAdapter()
        rvCategory.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvCategory.adapter = categoryAdapter
        rvCategory.isNestedScrollingEnabled = false
        /*rvCategory.addItemDecoration(
            DividerItemDecoration(
                rvCategory.context,
                LinearLayout.VERTICAL
            )
        )*/
        //animation
        rvCategory.adapter?.notifyDataSetChanged()
        rvCategory.scheduleLayoutAnimation()

        categoryAdapter.setonItemClickListener(object : CategoryAdapter.onItemclickListener {
            override fun onItemClick(position: Int, data: BusinessDirectory) {
                /*val intent = Intent(
                    this@SearchBusinessDirectoryActivity,
                    SearchBusinessDetailActivity::class.java
                )
                intent.putExtra("search_detail", Gson().toJson(data))
                startActivity(intent)*/
            }
        })

        categoryAdapter.setData(this, categoryItemList)
    }

}