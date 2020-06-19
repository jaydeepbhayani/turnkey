package anetos.software.turnkey.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Location(
    @PrimaryKey
    @SerializedName("trg_id")
    var id: Int = 0,
    @SerializedName("hoblicode")
    var code: String = "",
    @SerializedName("Hobli_gp")
    var name: String = "",
    var placeName: String = "",
    @SerializedName("ward_name")
    var wardName: String = "",
    @SerializedName("ward_no")
    var wardNo: Int = 0,
    @SerializedName("latitude")
    var latitude: String = "",
    @SerializedName("longitude")
    var longitude: String = ""
) : Parcelable