package anetos.software.turnkey.data.api.remote

/***
 *  created by jaydeepbhayani on 19/06/2020
 */

open class DataSourceException(message: String? = null) : Exception(message)

class RemoteDataNotFoundException : DataSourceException("Data not Found")