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
data class OtpResponse(
    @SerializedName("register_otp")
    var register_otp: List<RegisterOTP>
) : Parcelable

@Parcelize
data class RegisterOTP(
    @SerializedName("otp")
    var otp: String? = null,
    @SerializedName("otp_status")
    var otp_status: String? = null
) : Parcelable
