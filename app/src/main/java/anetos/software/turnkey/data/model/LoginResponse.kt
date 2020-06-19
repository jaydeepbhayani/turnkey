package anetos.software.turnkey.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Register Model
 *
 * created by jaydeepbhayani on 21/04/2020
 */
@Parcelize
data class LoginResponse(
    @SerializedName("login")
    var login: List<Login>
) : Parcelable

@Parcelize
data class Login(
    @SerializedName("result")
    var result: String? = null,
    @SerializedName("msg")
    var msg: String? = null
) : Parcelable
