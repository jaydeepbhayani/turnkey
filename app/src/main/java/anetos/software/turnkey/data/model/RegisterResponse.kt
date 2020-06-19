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
data class RegisterResponse(
    @SerializedName("register")
    var register: List<Register>
) : Parcelable

@Parcelize
data class Register(
    @SerializedName("value")
    var value: String? = null
) : Parcelable
