package anetos.software.turnkey.data.api.remote

import android.content.Context
import android.util.Log
import anetos.software.turnkey.data.UrlConstants.DASHBOARD_URL
import anetos.software.turnkey.data.UrlConstants.GET_ALL_REGISTER_DATA
import anetos.software.turnkey.data.UrlConstants.LOGIN_URL
import anetos.software.turnkey.data.UrlConstants.MARKETPLACE_URL
import anetos.software.turnkey.data.UrlConstants.OTP_URL
import anetos.software.turnkey.data.UrlConstants.REGISTER_URL
import anetos.software.turnkey.data.UrlConstants.SEARCHDATA_URL
import anetos.software.turnkey.data.api.ApiService
import anetos.software.turnkey.data.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * RemoteDataSourceImpl impl for RemoteDataSource
 *
 *  created by jaydeepbhayani on 19/06/2020
 */
class RemoteDataSourceImpl private constructor(
    private val apiService: ApiService/*,
    private val appdatabase: AppDatabase*/
) : RemoteDataSource {

    /**
     *  get register details
     */
    override suspend fun getRegisterData(
        surename: String, name: String, address: String, village: String,
        taluka: String, district: String, state: String, country: String,
        birthdate: String, gender: String, email: String, mobile: String,
        anniversarydate: String, maritalstatus: String, password: String
    ): Result<RegisterResponse> =
        withContext(Dispatchers.IO) {
            val request =
                apiService.getRegisterDataAsync(
                    REGISTER_URL
                        .replace("{surename}", surename)
                        .replace("{name}", name)
                        .replace("{address}", address)
                        .replace("{village}", village)
                        .replace("{taluka}", taluka)
                        .replace("{district}", district)
                        .replace("{state}", state)
                        .replace("{country}", country)
                        .replace("{birthdate}", birthdate)
                        .replace("{gender}", gender)
                        .replace("{mobile}", mobile)
                        .replace("{anniversarydate}", anniversarydate)
                        .replace("{maritalstatus}", maritalstatus)
                        .replace("{password}", password)
                )
            try {
                val response = request.await()
                Log.d("test", "RegisterData - Response - $response")
                if (response != null) {
                    Result.Success(response)
                } else {
                    Result.Error(RemoteDataNotFoundException())
                }
            } catch (ex: Throwable) {
                Result.Error(RemoteDataNotFoundException())
            }
        }

    /**
     *  get login details
     */
    override suspend fun getLoginData(mobile: String, password: String): Result<LoginResponse> =
        withContext(Dispatchers.IO) {
            val request =
                apiService.getLoginDataAsync(
                    LOGIN_URL
                        .replace("{mobile}", mobile)
                        .replace("{password}", password)
                )
            try {
                val response = request.await()
                Log.d("test", "LoginData - Response - $response")
                if (response != null) {
                    Result.Success(response)
                } else {
                    Result.Error(RemoteDataNotFoundException())
                }
            } catch (ex: Throwable) {
                Result.Error(RemoteDataNotFoundException())
            }
        }

    /**
     *  get otp details
     */
    override suspend fun getOtpData(mobile: String): Result<OtpResponse> =
        withContext(Dispatchers.IO) {
            val request =
                apiService.getOtpDataAsync(
                    OTP_URL
                        .replace("{mobile}", mobile)
                )
            try {
                val response = request.await()
                Log.d("test", "OtpData - Response - $response")
                if (response != null) {
                    Result.Success(response)
                } else {
                    Result.Error(RemoteDataNotFoundException())
                }
            } catch (ex: Throwable) {
                Result.Error(RemoteDataNotFoundException())
            }
        }

    /**
     *  get registerInfo details
     */
    override suspend fun getregisterInfoData(): Result<RegisterDataResponse> =
        withContext(Dispatchers.IO) {
            val request =
                apiService.getRegisterInfoDataAsync(
                    GET_ALL_REGISTER_DATA
                )
            try {
                val response = request.await()
                Log.d("test", "registerInfoData - Response - $response")
                if (response != null) {
                    Result.Success(response)
                } else {
                    Result.Error(RemoteDataNotFoundException())
                }
            } catch (ex: Throwable) {
                Result.Error(RemoteDataNotFoundException())
            }
        }

    /**
     *  get dashboard details
     */
    override suspend fun getDashboardData(): Result<DashboardResponse> =
        withContext(Dispatchers.IO) {
            val request =
                apiService.getDashboardDataAsync(
                    DASHBOARD_URL
                )
            try {
                val response = request.await()
                Log.d("test", "dashboardData - Response - $response")
                if (response != null) {
                    Result.Success(response)
                } else {
                    Result.Error(RemoteDataNotFoundException())
                }
            } catch (ex: Throwable) {
                Result.Error(RemoteDataNotFoundException())
            }
        }

    /**
     *  get searchdata details
     */
    override suspend fun getSearchData(): Result<SearchDataResponse> =
        withContext(Dispatchers.IO) {
            val request =
                apiService.getSearchDataAsync(
                    SEARCHDATA_URL
                )
            try {
                val response = request.await()
                Log.d("test", "searchData - Response - $response")
                if (response != null) {
                    Result.Success(response)
                } else {
                    Result.Error(RemoteDataNotFoundException())
                }
            } catch (ex: Throwable) {
                Result.Error(RemoteDataNotFoundException())
            }
        }

    /**
     *  get marketplacedata details
     */
    override suspend fun getMarketplaceData(): Result<MarketplaceDataResponse> =
        withContext(Dispatchers.IO) {
            val request =
                apiService.getMarketplaceDataAsync(
                    MARKETPLACE_URL
                )
            try {
                val response = request.await()
                Log.d("test", "marketplaceData - Response - $response")
                if (response != null) {
                    Result.Success(response)
                } else {
                    Result.Error(RemoteDataNotFoundException())
                }
            } catch (ex: Throwable) {
                Result.Error(RemoteDataNotFoundException())
            }
        }

    override suspend fun insertSafeRoute(source: String, destination: String) {
        //appdatabase.routeDao().insert(SafeRoute(0, source, destination))
    }

    companion object {
        fun newInstance(context: Context) =
            RemoteDataSourceImpl(
                ApiService.create(context)/*,
                AppDatabase.getInstance(context)*/
            )


    }
}