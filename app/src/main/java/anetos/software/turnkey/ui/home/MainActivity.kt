package anetos.software.turnkey.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import anetos.software.turnkey.R
import anetos.software.turnkey.core.SimpleDividerItemDecoration
import anetos.software.turnkey.core.setup
import anetos.software.turnkey.data.model.BusinessDirectory
import anetos.software.turnkey.data.model.NaviMenuItem
import anetos.software.turnkey.ui.common.CategoryAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_shop_by_style.view.*
import kotlinx.android.synthetic.main.layout_most_popular_brands.*
import kotlinx.android.synthetic.main.layout_shop_by_style.*
import kotlinx.android.synthetic.main.layout_whats_popular_furniture.*

/**
 *  created by jaydeepbhayani on 19/06/2020
 */

class MainActivity : AppCompatActivity() {

    val navigationItemList = arrayListOf(
        NaviMenuItem(
            title = R.string.menu_shop_by_department
        ), NaviMenuItem(
            title = R.string.menu_our_blogs
        ), NaviMenuItem(
            title = R.string.menu_need_help
        ), NaviMenuItem(
            title = R.string.menu_about_us
        )
    )

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

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    lateinit var mDrawerToggle: ActionBarDrawerToggle

    lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.app_name)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        drawerLayout = findViewById(R.id.drawer_layout)
        setUpDrawer()

        setAdapter()
        setShopByStyleAdapter()
        setPopularBrandAdapter()
    }

    private fun setAdapter() {
        categoryAdapter = CategoryAdapter()
        rvCategory.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
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

    fun setShopByStyleAdapter() {
        rvShopByStyle.setup(
            categoryItemList, R.layout.item_shop_by_style, { info ->
                ivPhoto.setImageResource(info.icon)

            },
            {
                android.util.Log.d("rvHeader", "onClick")
            }, LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        )
    }

    fun setPopularBrandAdapter() {
        rvPopularBrands.setup(
            categoryItemList, R.layout.item_most_popular_brands, { info ->
                ivPhoto.setImageResource(info.icon)

            },
            {
                android.util.Log.d("rvHeader", "onClick")
            }, LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        )
    }

    fun setUpDrawer() {
        val adapter = NavigationAdapter(/*this, navigationItemList*/)
        rv_navigation_menu.layoutManager = LinearLayoutManager(this)
        rv_navigation_menu.adapter = adapter
        /*rv_navigation_menu.addItemDecoration(
            DividerItemDecoration(
                rv_navigation_menu.context,
                LinearLayout.VERTICAL
            )
        )*/
        //rv_navigation_menu.addItemDecoration(SimpleDividerItemDecoration(rv_navigation_menu.context))
        adapter.setData(this, navigationItemList)
        mDrawerToggle = object :
            ActionBarDrawerToggle(
                this,
                drawer_layout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            ) {

        }
        drawerLayout.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()

        adapter.setOnItemClickLister(object : NavigationAdapter.OnItemSelecteListener {
            override fun onItemSelected(v: View, position: Int) {
                drawerLayout.closeDrawer(GravityCompat.START)
                //tv_content.text = menuItemList[position].title

                Snackbar.make(
                    v,
                    getString(navigationItemList[position].title) + " clicked",
                    Snackbar.LENGTH_SHORT
                )
                    .show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_cart -> {
                //showLanguageDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}