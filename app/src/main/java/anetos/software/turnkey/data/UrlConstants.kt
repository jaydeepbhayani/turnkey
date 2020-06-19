package anetos.software.turnkey.data

/**
 * All the const will go here.
 *
 *  created by jaydeepbhayani on 19/06/2020
 */
object UrlConstants {

    const val isOffline: Boolean = true

    const val BASE_URL = "https://bhavnagardirectoryb2b.com/samajapi/"
    const val REGISTER_URL =
        "register.php?surname={surname}&name={name}&address={address}&gam={village}&" +
                "taluka={taluka}&district={district}&state={state}&country={country}&birthdate={2020-01-31}&" +
                "gender={gender}&email={email}&mobile={mobile}&anniversarydate=2020-01-31&" +
                "maritalstatus={maritalstatus}&password={password}"
    const val LOGIN_URL = "login.php?mobile={mobile}&password={password}"
    const val OTP_URL = "sendotp.php?mobile={mobile}"
    const val GET_ALL_REGISTER_DATA = "getallregisterdata.php"
    const val DASHBOARD_URL = "dashboard.php"
    const val IMAGE_URL = BASE_URL + "{folder_name}/"
    const val SEARCHDATA_URL = "searchdata.php"
    const val MARKETPLACE_URL = "marketplacedata.php"
}