package anetos.software.turnkey.core

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import anetos.software.turnkey.ui.WorkInProgressActivity
import com.google.gson.Gson

class doAsync(val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
    init {
        execute()
    }

    override fun doInBackground(vararg params: Void?): Void? {
        handler()
        return null
    }
}

fun AppCompatActivity.workInProgresActivity(title: Int) {
    val intent = Intent(this, WorkInProgressActivity::class.java)
    intent.putExtra("title", this.resources.getString(title))
    startActivity(intent)
}


inline fun <reified T> Context.getObjectFromJson(jsonFileName: String): T {
    val fileInString: String =
        applicationContext.assets.open(jsonFileName).bufferedReader().use { it.readText() }
    return Gson().fromJson(fileInString, T::class.java)
}

fun getUrl(url: String): String? {
    if (!url.startsWith("http://") && !url.startsWith("https://"))
        return "http://" + url

    return null
}