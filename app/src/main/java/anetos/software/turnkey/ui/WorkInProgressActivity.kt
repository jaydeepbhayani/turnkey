package anetos.software.turnkey.ui

import android.os.Bundle
import android.view.MenuItem
import anetos.software.turnkey.R
import anetos.software.turnkey.core.BaseActivity

/***
 *  created by jaydeepbhayani on 19/06/2020
 */

class WorkInProgressActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_display_work_in_progress)
        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            title = intent.getStringExtra("title")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
