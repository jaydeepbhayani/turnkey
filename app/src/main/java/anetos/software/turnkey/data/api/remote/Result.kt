package anetos.software.turnkey.data.api.remote

/**
 * Helper class for api data used in retrofit
 *
 *  created by jaydeepbhayani on 19/06/2020
 */
sealed class Result<out T : Any> {

    class Success<out T : Any>(val data: T) : Result<T>()

    class Error(val exception: Throwable) : Result<Nothing>()
}