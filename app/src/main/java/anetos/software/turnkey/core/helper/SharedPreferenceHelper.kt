package anetos.software.turnkey.core.helper

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import java.lang.reflect.Type


/***
 *  created by jaydeepbhayani on 19/06/2020
 */
class SharedPreferenceHelper(val context: Context) {
    private val prefName = "UrbanFlooding"
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    fun save(KEY_NAME: String, value: Int) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt(KEY_NAME, value)
        editor.apply()
    }

    fun saveString(KEY_NAME: String, value: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_NAME, value)
        editor.apply()
    }

    fun saveBoolean(KEY_NAME: String, value: Boolean) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putBoolean(KEY_NAME, value)
        editor.apply()
    }

    fun getValueInt(KEY_NAME: String): Int = sharedPref.getInt(KEY_NAME, 1)

    fun getValueBoolean(KEY_NAME: String): Boolean = sharedPref.getBoolean(KEY_NAME, true)

    fun getValueString(KEY_NAME: String): String? = sharedPref.getString(KEY_NAME, null)

    fun saveObjectToSharedPreference(
        serializedObjectKey: String,
        `object`: Any
    ) {
        val sharedPreferencesEditor = sharedPref.edit()
        val serializedObject = Gson().toJson(`object`)
        sharedPreferencesEditor.putString(serializedObjectKey, serializedObject)
        sharedPreferencesEditor.apply()
    }

    fun <T> getSavedObjectFromPreference(
        preferenceKey: String,
        classType: Type
    ): T? {
        if (sharedPref.contains(preferenceKey)) {
            return Gson().fromJson(sharedPref.getString(preferenceKey, ""), classType)
        }
        return null
    }

    fun clearAllData(){
        sharedPref.edit()
            .clear()
            .commit()
    }
}
