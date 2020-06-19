package anetos.software.turnkey.data.repository

import androidx.lifecycle.MutableLiveData
import anetos.software.turnkey.data.api.remote.RemoteDataNotFoundException
import anetos.software.turnkey.data.api.remote.RemoteDataSource
import anetos.software.turnkey.data.api.remote.Result
import anetos.software.turnkey.data.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class DataMainRepository

/**
 * A data repo containing a weather, forecast, rainfall details.
 *
 *  created by jaydeepbhayani on 21/04/2020
 */
class DataRepository(
    private val dataSource: RemoteDataSource/*,
    private val appDatabase: AppDatabase*/
) : DataMainRepository() {

    val loginData: MutableLiveData<LoginResponse> = MutableLiveData()
    val registerData: MutableLiveData<RegisterResponse> = MutableLiveData()
    val otpData: MutableLiveData<OtpResponse> = MutableLiveData()
    val registerInfoData: MutableLiveData<RegisterDataResponse> = MutableLiveData()
    val dashboardData: MutableLiveData<DashboardResponse> = MutableLiveData()
    val searchData: MutableLiveData<SearchDataResponse> = MutableLiveData()
    val marketplaceData: MutableLiveData<MarketplaceDataResponse> = MutableLiveData()

    /**
     * [Live Data] to load registerData.  registerData's will be loaded from the repository cache.
     * Observing this will not cause the repos to be refreshed, use [refreshRegisterData].
     */
    suspend fun refreshRegisterData(
        surename: String, name: String, address: String, village: String,
        taluka: String, district: String, state: String, country: String,
        birthdate: String, gender: String, email: String, mobile: String,
        anniversarydate: String, maritalstatus: String, password: String
    ) {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.getRegisterData(
                    surename, name, address, village,
                    taluka, district, state, country,
                    birthdate, gender, email, mobile,
                    anniversarydate, maritalstatus, password
                )
                if (result is Result.Success) {
                    registerData.postValue(result.data)
                }

            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }

    /**
     * [Live Data] to load loginData.  loginData's will be loaded from the repository cache.
     * Observing this will not cause the repos to be refreshed, use [refreshLoginData].
     */
    suspend fun refreshLoginData(mobile: String, password: String) {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.getLoginData(mobile, password)
                if (result is Result.Success) {
                    loginData.postValue(result.data)
                }

            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }

    /**
     * [Live Data] to load otpData.  otpData's will be loaded from the repository cache.
     * Observing this will not cause the repos to be refreshed, use [refreshOtpData].
     */
    suspend fun refreshOtpData(mobile: String) {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.getOtpData(mobile)
                if (result is Result.Success) {
                    otpData.postValue(result.data)
                }

            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }

    /**
     * [Live Data] to load registerInfoData.  otpData's will be loaded from the repository cache.
     * Observing this will not cause the repos to be refreshed, use [refreshregisterInfoData].
     */
    suspend fun refreshregisterInfoData() {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.getregisterInfoData()
                if (result is Result.Success) {
                    registerInfoData.postValue(result.data)
                }

            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }

    /**
     * [Live Data] to load refreshDashboardData.
     * refreshDashboardData's will be loaded from the repository cache.
     * Observing this will not cause the repos to be refreshed, use [refreshDashboardData].
     */
    suspend fun refreshDashboardData() {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.getDashboardData()
                if (result is Result.Success) {
                    dashboardData.postValue(result.data)
                }

            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }

    /**
     * [Live Data] to load refreshSearchData.
     * refreshSearchData's will be loaded from the repository cache.
     * Observing this will not cause the repos to be refreshed, use [refreshSearchData].
     */
    suspend fun refreshSearchData() {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.getSearchData()
                if (result is Result.Success) {
                    searchData.postValue(result.data)
                }

            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }

    /**
     * [Live Data] to load refreshMarketplaceData.
     * refreshMarketplaceData's will be loaded from the repository cache.
     * Observing this will not cause the repos to be refreshed, use [refreshMarketplaceData].
     */
    suspend fun refreshMarketplaceData() {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.getMarketplaceData()
                if (result is Result.Success) {
                    marketplaceData.postValue(result.data)
                }

            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }
/*
    */
    /**
     * Refresh the current repos and save the results to the offline cache.
     * This method does not return new repos. Use [forecastData] for that.
     *//*
    suspend fun refreshForecastData(locationCode: String, date: Date) {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.getForecastData(locationCode, date)
                if (result is Result.Success) {
                    forecastData.postValue(result.data)
                }

            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }

    */
    /**
     * Refresh the current repos and save the results to the offline cache.
     * This method does not return new repos. Use [rainfallData] for that.
     *//*
    suspend fun refreshRainfallData(locationCode: String) {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.getRainfallData(locationCode)
                if (result is Result.Success) {
                    rainfallData.postValue(result.data)
                }

            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }

    */
    /**
     * Refresh the current repos and save the results to the offline cache.
     * This method does not return new repos. Use [rainfallData] for that.
     * Today's Rainfall for forecast
     *//*
    suspend fun refreshTodayRainfallData() {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.getTodayRainfallData()
                if (result is Result.Success) {
                    todayRainfallData.postValue(result.data)
                }

            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }

    */
    /**
     * Refresh the current repos and save the results to the offline cache.
     * This method does not return new repos. Use [rainfallData] for that.
     * Today's Rainfall for forecast
     *//*
    suspend fun refreshYesterdayRainfallData() {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.getYesterdayRainfallData()
                if (result is Result.Success) {
                    yesterdayRainfallData.postValue(result.data)
                }

            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }

    */
    /**
     * Refresh the current repos and save the results to the offline cache.
     * This method does not return new repos. Use [rainfallData] for that.
     *//*
    suspend fun refreshFloodData(locationCode: String) {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.getFloodData(locationCode)
                if (result is Result.Success) {
                    floodData.postValue(result.data)
                }

            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }

    */
    /**
     * Refresh the current repos and save the results to the offline cache.
     * This method does not return new repos. Use [locationData] for that.
     *//*
    suspend fun refreshLocationData() {
        withContext(Dispatchers.IO) {
            try {
                val locationFromDb = appDatabase.locationDao().getAll()
                Log.d("test", "LocationFromDb $locationFromDb")
                locationData.postValue(locationFromDb)
            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            } catch (npe: NullPointerException) {
                throw DataRefreshError(npe)
            }
        }
    }

    */
    /**
     * Refresh the current repos and save the results to the offline cache.
     * This method does not return new repos. Use [locationData] for that.
     *//*
    suspend fun refreshSafeRouteData() {
        withContext(Dispatchers.IO) {
            try {
                val routeFromDb = appDatabase.routeDao().getAll()
                safeRouteData.postValue(routeFromDb)
            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }


    */
    /**
     * Refresh the current repos and save the results to the offline cache.
     * This method does not return new repos. Use [locationData] for that.
     *//*
    suspend fun refreshLocationfromDB() {
        withContext(Dispatchers.IO) {
            try {
                val locationFromDb = appDatabase.locationDao().getAll()

                if (locationFromDb.isEmpty()) {

                } else {
                    Log.d("test", "LocationFromDb $locationFromDb")
                    locationData.postValue(locationFromDb)
                }
            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }

    suspend fun getSearchLocationData(latitude: String, longitude: String, placeName: String) {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.searchLocation(latitude, longitude)
                if (result is Result.Success) {
                    val locationData = result.data[0]
                    if (placeName.isNotEmpty()) {
                        locationData.placeName = placeName
                    } else {
                        locationData.placeName = locationData.wardName
                    }
                    appDatabase.locationDao().insert(locationData)
                    searchLocationData.postValue(result.data)
                }
            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }

    *//*   *//*
    */
    /**
     * [Live Data] to load map direction.  direction data's will be loaded from the repository cache.
     * Observing this will not cause the repos to be refreshed, use [map direction].
     *//**//*
    suspend fun refreshMapDirection(startPoint: String, endPoint: String) {
        withContext(Dispatchers.IO) {
            try {
                val result = dataSource.getMapDirections(startPoint, endPoint)
                if (result is Result.Success) {
                    directionData.postValue(result.data)
                }

            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }*//*

    fun getLocationByPlaceName(placeName: String): Location? {
        return try {
            val locationFromDb = appDatabase.locationDao().getByPlaceName(placeName)
            Log.d("getLocationByPlaceName", "LocationFromDb $locationFromDb")
            locationFromDb
        } catch (error: Exception) {
            null
        }
    }

    fun getLocationByLatLon(latitude: String, longitude: String): Location? {
        return try {
            val locationFromDb = appDatabase.locationDao().getByLatLon(latitude, longitude)
            Log.d("test", "LocationFromDb $locationFromDb")
            locationFromDb
        } catch (error: Exception) {
            null
        }
    }

    fun getAllLocation(): List<Location>? {
        return try {
            val locationFromDb = appDatabase.locationDao().getAll()
            Log.d("test", "LocationFromDb $locationFromDb")
            locationFromDb
        } catch (error: Exception) {
            null
        }
    }

    fun getAllSafeRoute(): List<SafeRoute>? {
        return try {
            val routeFromDb = appDatabase.routeDao().getAll()
            Log.d("test", "routeFromDb $routeFromDb")
            routeFromDb
        } catch (error: Exception) {
            null
        }
    }

    fun getSafeRouteByLocation(start: String, destination: String): SafeRoute? {
        return try {
            val routeFromDb = appDatabase.routeDao().getByLocations(start, destination)
            Log.d("test", "getSafeRouteByLocation $routeFromDb")
            routeFromDb
        } catch (error: Exception) {
            null
        }
    }


    suspend fun insertSafeRoute(source: String, destination: String) {
        withContext(Dispatchers.IO) {
            try {
                dataSource.insertSafeRoute(source, destination)
            } catch (error: RemoteDataNotFoundException) {
                throw DataRefreshError(error)
            }
        }
    }*/

    class DataRefreshError(cause: Throwable) : Throwable(cause.message, cause)
}