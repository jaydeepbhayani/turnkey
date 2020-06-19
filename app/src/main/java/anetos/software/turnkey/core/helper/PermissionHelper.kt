package anetos.software.turnkey.core.helper

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment

object PermissionHelper {

    val TAG = javaClass.simpleName

    private const val LOCATION_PERMISSION_REQUEST_CODE = 1000

    fun checkPermission(activity: Activity) {
        if (ActivityCompat.checkSelfPermission(
                activity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }
    }

    fun requestLocationPermission(
        activity: Activity,
        fragment: Fragment?,
        requestCode: Int,
        message: String
    ): Boolean {
        return requestPermission(
            activity,
            fragment,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            requestCode,
            message
        )
    }

    fun checkLocationPermission(activity: Context): Boolean {
        return checkPermission(
            activity,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    private fun checkPermission(activity: Context?, permissions: Array<String>): Boolean {
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(
                    activity!!,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            )
                return false
        }

        return true
    }

    private fun requestPermission(
        activity: Activity,
        fragment: Fragment?,
        permissions: Array<String>,
        requestCode: Int,
        message: String
    ): Boolean {
        var context: Context? = activity
        if (fragment != null) {
            context = fragment.context
        }
        val isAllow = checkPermission(context, permissions)
        if (!isAllow) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    activity,
                    permissions[0]
                )
            ) {
                val dialog = AlertDialog.Builder(context!!)
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok) { _, _ ->
                        if (fragment == null) {
                            ActivityCompat.requestPermissions(
                                activity,
                                permissions,
                                requestCode
                            )
                        } else {
                            fragment.requestPermissions(permissions, requestCode)
                        }
                    }
                    .create()
                dialog.show()
            } else {
                if (fragment == null) {
                    ActivityCompat.requestPermissions(
                        activity,
                        permissions,
                        requestCode
                    )
                } else {
                    fragment.requestPermissions(permissions, requestCode)
                }
            }

            return false
        } else {
            return true
        }
    }
}