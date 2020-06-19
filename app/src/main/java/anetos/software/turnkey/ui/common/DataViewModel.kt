package anetos.software.turnkey.ui.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import anetos.software.turnkey.core.viewModelFactoryWithSingleArg
import anetos.software.turnkey.data.api.remote.RemoteDataNotFoundException
import anetos.software.turnkey.data.repository.DataRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/***
 *  created by jaydeepbhayani on 21/04/2020
 */
/*class GoogleDataViewModel(private val repository: GoogleDataRepository) : ViewModel() {

    companion object {
        val FACTORY =
            viewModelFactoryWithSingleArg(::GoogleDataViewModel)
    }

    */
/**
 *  Get the Map Directions from start pint to end point from google Direction Api
 *//*
    val mapDirections = repository.directionData

    fun refreshMapDirection(startPoint: String, endPoint: String) {
        launchDataLoad {
            repository.refreshMapDirection(startPoint, endPoint)
        }
    }

    //--------------------------------------------------------------------------------------------//
    *//***
 * SnackBar and Spinner common for all datas
 *//*
    private var _snackBar: MutableLiveData<String> = MutableLiveData()
    val snackbar: LiveData<String> get() = _snackBar
    var spinner: MutableLiveData<Boolean> = MutableLiveData()
    val spinner1: LiveData<Boolean> get() = spinner

    private fun launchDataLoad(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                spinner.value = true
                block()
            } catch (error: RemoteDataNotFoundException) {
                _snackBar.value = error.message
            } finally {
                spinner.value = false
            }
        }
    }
    //--------------------------------------------------------------------------------------------//
}*/

class DataViewModel(private val repository: DataRepository) : ViewModel() {

    companion object {
        val FACTORY =
            viewModelFactoryWithSingleArg(::DataViewModel)
    }

    /**
     *  Enable/Disable legends
     */
    val isLegendsEnabled = MutableLiveData<Boolean>()


    fun enableLegends(isEnabled: Boolean) = isLegendsEnabled.postValue(isEnabled)

    /**
     *  Login Data mapping and refresh
     */
    val loginData = repository.loginData
    fun refreshLoginData(mobile: String, password: String) {
        launchDataLoad { repository.refreshLoginData(mobile, password) }
    }

    /**
     *  Register Data mapping and refresh
     */
    val registerData = repository.registerData
    fun refreshRegisterData(
        surename: String, name: String, address: String, village: String,
        taluka: String, district: String, state: String, country: String,
        birthdate: String, gender: String, email: String, mobile: String,
        anniversarydate: String, maritalstatus: String, password: String
    ) {
        launchDataLoad {
            repository.refreshRegisterData(
                surename, name, address, village, taluka, district, state, country,
                birthdate, gender, email, mobile, anniversarydate, maritalstatus, password
            )
        }
    }

    /**
     *  Otp Data mapping and refresh
     */
    val otpData = repository.otpData
    fun refreshOtpData(mobile: String) {
        launchDataLoad {
            repository.refreshOtpData(mobile)
        }
    }

    /**
     *  Register info Data mapping and refresh
     */
    val registerInfoData = repository.registerInfoData
    fun refreshregisterInfoData() {
        launchDataLoad {
            repository.refreshregisterInfoData()
        }
    }

    /**
     *  Dashboard Data mapping and refresh
     */
    val dashboardData = repository.dashboardData
    fun refreshDashboardData() {
        launchDataLoad {
            repository.refreshDashboardData()
        }
    }

    /**
     *  Search Data mapping and refresh
     */
    val searchData = repository.searchData
    fun refreshSearchData() {
        launchDataLoad {
            repository.refreshSearchData()
        }
    }

    /**
     *  Marketplace Data mapping and refresh
     */
    val marketplaceData = repository.marketplaceData
    fun refreshMarketplaceData() {
        launchDataLoad {
            repository.refreshMarketplaceData()
        }
    }

    //fun getAllLocation(): List<Location>? = repository.getAllLocation()

    /*fun getSafeRouteByLocation(source: String, destination: String): SafeRoute? =
        repository.getSafeRouteByLocation(source, destination)*/

    //--------------------------------------------------------------------------------------------//
    /***
     * SnackBar and Spinner common for all datas
     */
    private var _snackBar: MutableLiveData<String> = MutableLiveData()
    val snackbar: LiveData<String> get() = _snackBar
    var spinner: MutableLiveData<Boolean> = MutableLiveData()
    val spinner1: LiveData<Boolean> get() = spinner

    private fun launchDataLoad(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                spinner.value = true
                block()
            } catch (error: RemoteDataNotFoundException) {
                _snackBar.value = error.message
            } finally {
                spinner.value = false
            }
        }
    }
    //--------------------------------------------------------------------------------------------//
}