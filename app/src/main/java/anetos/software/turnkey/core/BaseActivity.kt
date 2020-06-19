package anetos.software.turnkey.core

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import anetos.software.turnkey.R
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar


/***
 *  created by jaydeepbhayani on 19/06/2020
 */

abstract class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleManager.setLocale(base))
    }

    fun setNewLocale(mContext: AppCompatActivity, @LocaleManager.LocaleDef language: String) {
        LocaleManager.setNewLocale(this, language)
        val intent = mContext.intent
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
    }

   /* fun getUserId(): String {
      return getSharedPreferences(
              Constants.Preferences.APP_PREF_NAME, Context.MODE_PRIVATE
      )?.getString(Constants.Preferences.USER_ID, null).toString()
    }

    fun isVerified(): Boolean {
        return getSharedPreferences(
                Constants.Preferences.APP_PREF_NAME, Context.MODE_PRIVATE
        ).getBoolean(Constants.Preferences.IS_VERIFIED, false)
    }
    fun getDeviceToken(): String {
        return getSharedPreferences(
                Constants.Preferences.APP_PREF_NAME, Context.MODE_PRIVATE
        )?.getString(Constants.Preferences.DEVICE_TOKEN, null).toString()
    }*/

    fun showSnackBar(container: View, message: String, buttonText: String) {
        val snackbar = Snackbar.make(container, message, BaseTransientBottomBar.LENGTH_LONG)
        snackbar.setAction(buttonText) { view -> snackbar.dismiss() }
        snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.colorAccent))
        snackbar.show()
    }

    val isConnectedToInternet: Boolean?
        get() {
            val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }

    fun hideKeyboard(){
        val view = currentFocus
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(view?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}
