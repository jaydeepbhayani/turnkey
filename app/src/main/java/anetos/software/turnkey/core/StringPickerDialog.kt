package anetos.software.turnkey.core

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Point
import android.os.Bundle
import android.text.TextUtils
import android.view.Display
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.ListPopupWindow.MATCH_PARENT
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import java.util.*


/***
 *  created by jaydeepbhayani on 05/05/2020
 */
class StringPickerDialog : DialogFragment() {
    private val items: MutableList<String> =
        ArrayList()
    private var title: String? = null
    private var listener: OnSelectedListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        val newItems: List<String>? =
            args!!.getStringArrayList(ARGS_ITEMS)
        if (newItems != null) {
            items.clear()
            items.addAll(newItems)
        }
        title = args.getString(ARGS_TITLE)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder =
            AlertDialog.Builder(requireActivity())
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title)
        }
        builder.setItems(
            items.toTypedArray()
        ) { dialog: DialogInterface?, which: Int ->
            if (listener != null) {
                listener!!.onSelect(items[which], which)
            }
        }
        return builder.create()
    }

    interface OnSelectedListener {
        fun onSelect(value: String?, which: Int)
    }

    fun setOnSelectedListener(listener: OnSelectedListener?) {
        this.listener = listener
    }

    companion object {
        private const val ARGS_ITEMS = "items"
        private const val ARGS_TITLE = "title"
        fun newInstance(
            title: String?,
            items: List<String?>?
        ): StringPickerDialog {
            val args = Bundle()
            args.putStringArrayList(
                ARGS_ITEMS,
                items as ArrayList<String?>?
            )
            args.putString(ARGS_TITLE, title)
            val fragment = StringPickerDialog()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onResume() {
        val window: Window? = dialog!!.window
        val size = Point()
        val display: Display = window?.getWindowManager()?.getDefaultDisplay()!!
        display.getSize(size)
        window.setLayout((size.x * 0.9).toInt(), (size.x * 0.9).toInt())
        window.setGravity(Gravity.CENTER)
        super.onResume()
        /*val window = dialog!!.window ?: return
        val params = window.attributes
        params.width = MATCH_PARENT
        params.height = MATCH_PARENT
        window.attributes = params*/
    }
}