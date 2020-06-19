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
data class RegisterDataResponse(
    @SerializedName("registerdata")
    var registerdata: RegisterData
) : Parcelable

@Parcelize
data class RegisterData(
    @SerializedName("surname")
    var surname: List<Surname>,
    @SerializedName("village")
    var village: List<Village>,
    @SerializedName("taluka")
    var taluka: List<Taluka>,
    @SerializedName("district")
    var district: List<District>,
    @SerializedName("state")
    var state: List<State>,
    @SerializedName("country")
    var country: List<Country>
) : Parcelable

@Parcelize
data class Surname (
    @SerializedName("recordid")
    var recordid: String? = null,
    @SerializedName("surname")
    var surname: String? = null,
    @SerializedName("status")
    var status: String? = null
) : Parcelable

@Parcelize
data class Village (
    @SerializedName("recordid")
    var recordid: String? = null,
    @SerializedName("gt_Village")
    var gt_Taluka: String? = null,
    @SerializedName("gt_Did")
    var gt_Did: String? = null,
    @SerializedName("gt_Sid")
    var gt_Sid: String? = null,
    @SerializedName("gt_Cid")
    var gt_Cid: String? = null,
    @SerializedName("gt_Status")
    var gt_Status: String? = null
) : Parcelable

@Parcelize
data class Taluka (
    @SerializedName("recordid")
    var recordid: String? = null,
    @SerializedName("gt_Taluka")
    var gt_Taluka: String? = null,
    @SerializedName("districtid")
    var districtid: String? = null,
    @SerializedName("stateid")
    var stateid: String? = null,
    @SerializedName("countryid")
    var countryid: String? = null,
    @SerializedName("gt_Status")
    var gt_Status: String? = null
) : Parcelable

@Parcelize
data class District (
    @SerializedName("recordid")
    var recordid: String? = null,
    @SerializedName("districtid")
    var districtid: String? = null,
    @SerializedName("stateid")
    var stateid: String? = null,
    @SerializedName("countryid")
    var countryid: String? = null,
    @SerializedName("gt_Status")
    var gt_Status: String? = null
) : Parcelable

@Parcelize
data class State (
    @SerializedName("recordid")
    var recordid: String? = null,
    @SerializedName("gs_State")
    var gs_State: String? = null,
    @SerializedName("countryid")
    var countryid: String? = null,
    @SerializedName("gs_Status")
    var gs_Status: String? = null
) : Parcelable

@Parcelize
data class Country (
    @SerializedName("recordid")
    var recordid: String? = null,
    @SerializedName("gc_Title")
    var gc_Title: String? = null,
    @SerializedName("gc_Status")
    var gc_Status: String? = null
) : Parcelable