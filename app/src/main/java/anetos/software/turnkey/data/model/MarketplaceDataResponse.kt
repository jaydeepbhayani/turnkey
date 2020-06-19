package anetos.software.turnkey.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Marketplace Model
 *
 * created by jaydeepbhayani on 17/06/2020
 */

@Parcelize
data class MarketplaceDataResponse(
    @SerializedName("marketplacedata")
    var marketplacedata: MarketplaceData
) : Parcelable

@Parcelize
data class MarketplaceData(
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
    @SerializedName("marketplace")
    var marketplaceDirectory: List<MarketplaceDirectory>,
    @SerializedName("marketplace_slider")
    var marketplace_slider: List<MarketplaceSlider>

) : Parcelable

@Parcelize
data class MarketplaceDirectory(
    @SerializedName("recordid")
    var recordid: String? = null,
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("categoryid")
    var categoryid: String? = null,
    @SerializedName("amount")
    var amount: String? = null,
    @SerializedName("description")
    var description: String? = null,
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
data class MarketplaceSlider(
    @SerializedName("recordid")
    var recordid: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("status")
    var status: String? = null
) : Parcelable