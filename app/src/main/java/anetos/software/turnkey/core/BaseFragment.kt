package anetos.software.turnkey.core

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import anetos.software.turnkey.R
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar


/***
 *  created by jaydeepbhayani on 19/06/2020
 */

abstract class BaseFragment : Fragment() {

    fun showSnackBar(container: View, message: String, buttonText: String, isFinish: Boolean) {
        val snackbar = Snackbar.make(container, message, BaseTransientBottomBar.LENGTH_INDEFINITE)
        snackbar.setAction(buttonText) { view -> snackbar.dismiss()
        if (isFinish)
            activity?.finish()
        }
        snackbar.setActionTextColor(ContextCompat.getColor(requireContext(), R.color.colorAccent))
        snackbar.show()
    }

    fun hideKeyboard(activity: Activity, view: View) {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    val mHideKeyBoard = {
        val view = activity?.currentFocus
        if (view != null) {
            val inputManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val view = activity?.currentFocus
        if (view != null) {
            val inputManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}