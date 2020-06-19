package anetos.software.turnkey.core

import android.app.Activity
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction



/***
 *  created by jaydeepbhayani on 19/06/2020
 */
inline fun FragmentManager.transaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun AppCompatActivity.add(fragment: Fragment, container: Int) {
    supportFragmentManager.transaction { add(container, fragment) }
}

fun FragmentManager.add(fragment: Fragment, container: Int) {
    this.transaction { add(container, fragment) }
}

fun AppCompatActivity.replace(fragment: Fragment, container: Int) {
    supportFragmentManager.transaction { replace(container, fragment) }
}

fun hideKeyboard(activity: Activity, view: View) {
    val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}