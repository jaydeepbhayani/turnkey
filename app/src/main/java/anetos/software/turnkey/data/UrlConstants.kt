package anetos.software.turnkey.data

/**
 * All the const will go here.
 *
 *  created by jaydeepbhayani on 19/06/2020
 */
object UrlConstants {

    const val isOffline: Boolean = true

    const val BASE_URL = ""
    const val REGISTER_URL =
        "register.php?name={name}&email={email}&mobile={mobile}&password={password}"
    const val LOGIN_URL = "login.php?mobile={mobile}&password={password}"
    const val OTP_URL = "sendotp.php?mobile={mobile}"
    const val IMAGE_URL = BASE_URL + "{folder_name}/"
    const val SEARCHDATA_URL = "searchdata.php"
}