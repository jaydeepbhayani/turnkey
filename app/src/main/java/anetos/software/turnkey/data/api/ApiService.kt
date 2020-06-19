package anetos.software.turnkey.data.api

import android.content.Context
import anetos.software.turnkey.core.Networking
import anetos.software.turnkey.data.model.*
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Url


/**
 * Api service interface to handle all the data from retrofit
 *
 *  created by jaydeepbhayani on 19/06/2020
 */
interface ApiService {

    @GET
    fun getRegisterDataAsync(@Url url: String): Deferred<RegisterResponse>

    @GET
    fun getLoginDataAsync(@Url url: String): Deferred<LoginResponse>

    @GET
    fun getOtpDataAsync(@Url url: String): Deferred<OtpResponse>

    @GET
    fun getRegisterInfoDataAsync(@Url url: String) : Deferred<RegisterDataResponse>

    @GET
    fun getDashboardDataAsync(@Url url: String) : Deferred<DashboardResponse>

    @GET
    fun getSearchDataAsync(@Url url: String) : Deferred<SearchDataResponse>

    @GET
    fun getMarketplaceDataAsync(@Url url: String) : Deferred<MarketplaceDataResponse>

    companion object {

        fun create(context: Context): ApiService {
            return Networking.create(context)
        }
    }
}