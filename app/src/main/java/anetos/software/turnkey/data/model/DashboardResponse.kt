package anetos.software.turnkey.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Register Model
 *
 * created by jaydeepbhayani on 26/05/2020
 */

@Parcelize
data class DashboardResponse(
    @SerializedName("dashboarddata")
    var dashboarddata: DashboardData
) : Parcelable

@Parcelize
data class DashboardData(
    @SerializedName("dashboard_slider")
    var dashboard_slider: List<DashboardSlider>,
    @SerializedName("categories")
    var categories: List<Category>,
    @SerializedName("tribute")
    var tribute: List<Tribute>,
    @SerializedName("donation")
    var donation: List<Donation>,
    @SerializedName("convener")
    var convener: List<Convener>
) : Parcelable

@Parcelize
data class DashboardSlider(
    @SerializedName("recordid")
    var recordid: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("status")
    var status: String? = null
) : Parcelable

@Parcelize
data class Category(
    @SerializedName("categoryid")
    var categoryid: String? = null,
    @SerializedName("categoryname")
    var categoryname: String? = null,
    @SerializedName("categoryphoto")
    var categoryphoto: String? = null,
    @SerializedName("status")
    var status: String? = null
) : Parcelable

@Parcelize
data class Tribute(
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
data class Donation(
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
data class Convener(
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