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
data class SearchDataResponse(
    @SerializedName("searchdata")
    var searchdata: SearchData
) : Parcelable

@Parcelize
data class SearchData(
    @SerializedName("categories")
    var categories: List<Category>,
    @SerializedName("taluka")
    var taluka: List<Taluka>,
    @SerializedName("district")
    var district: List<District>,
    @SerializedName("tags")
    var tags: List<Tags>,
    @SerializedName("taluka_district_wise")
    var taluka_district_wise: List<taluka_district_wise>,
    @SerializedName("businessdirectory")
    var businessdirectory: List<BusinessDirectory>,
    @SerializedName("businessdirectory_slider")
    var businessdirectory_slider: List<BusinessDirectorySlider>
) : Parcelable

@Parcelize
data class taluka_district_wise(
    @SerializedName("recordid")
    var recordid: String? = null,
    @SerializedName("taluka_name")
    var taluka_name: String? = null,
    @SerializedName("districtid")
    var districtid: String? = null,
    @SerializedName("stateid")
    var stateid: String? = null,
    @SerializedName("countryid")
    var countryid: String? = null,
    @SerializedName("status")
    var status: String? = null
) : Parcelable

@Parcelize
data class Tags(
    @SerializedName("recordid")
    var recordid: String? = null,
    @SerializedName("tagvalue")
    var tagvalue: String? = null
) : Parcelable

@Parcelize
data class BusinessDirectory(
    @SerializedName("recordid")
    var recordid: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("categoryid")
    var categoryid: String? = null,
    @SerializedName("address")
    var address: String? = null,
    @SerializedName("gam")
    var gam: String? = null,
    @SerializedName("locationid")
    var locationid: String? = null,
    @SerializedName("contactno")
    var contactno: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("logo")
    var logo: String? = null,
    @SerializedName("website")
    var website: String? = null,
    @SerializedName("facebooklink")
    var facebooklink: String? = null,
    @SerializedName("twitterlink")
    var twitterlink: String? = null,
    @SerializedName("instagramlink")
    var instagramlink: String? = null,
    @SerializedName("linkedin")
    var linkedin: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("userid")
    var userid: String? = null,
    @SerializedName("tags")
    var tags: String? = null,
    @SerializedName("photos")
    var photos: String? = null,
    @SerializedName("status")
    var status: String? = null
) : Parcelable

@Parcelize
data class BusinessDirectorySlider(
    @SerializedName("recordid")
    var recordid: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("status")
    var status: String? = null
) : Parcelable