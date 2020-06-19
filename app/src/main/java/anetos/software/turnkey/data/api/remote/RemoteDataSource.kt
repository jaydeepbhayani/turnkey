package anetos.software.turnkey.data.api.remote

import anetos.software.turnkey.data.model.*


/**
 * Handle remote data
 * Add the data here and handle in the implementation
 *
 *  created by jaydeepbhayani on 21/04/2020
 */
interface RemoteDataSource {
    suspend fun getRegisterData(surename: String, name: String, address: String, village: String,
                                taluka: String, district: String, state: String, country: String,
                                birthdate: String, gender: String, email: String, mobile: String,
                                anniversarydate: String, maritalstatus: String, password: String): Result<RegisterResponse>
    suspend fun getLoginData(mobile: String, password: String): Result<LoginResponse>
    suspend fun getOtpData(mobile: String): Result<OtpResponse>
    suspend fun getregisterInfoData(): Result<RegisterDataResponse>
    suspend fun getDashboardData(): Result<DashboardResponse>
    suspend fun getSearchData(): Result<SearchDataResponse>
    suspend fun getMarketplaceData(): Result<MarketplaceDataResponse>

    suspend fun insertSafeRoute(source: String, destination: String)
}