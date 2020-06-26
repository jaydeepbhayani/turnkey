package anetos.software.turnkey.core

import android.content.Context
import anetos.software.turnkey.BuildConfig
import anetos.software.turnkey.core.InternetCheck
import anetos.software.turnkey.data.UrlConstants
import anetos.software.turnkey.data.api.ApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


/***
 *  created by jaydeepbhayani on 19/06/2020
 */

object Networking {
    private const val NETWORK_CALL_TIMEOUT = 60

    fun create(context: Context): ApiService {
        val cacheDir = File(context.cacheDir, "offlineCache")

        //10 MB
        val cacheSize = Cache(cacheDir, 10 * 1024 * 1024)

        return Retrofit.Builder()
            .baseUrl(UrlConstants.BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .cache(cacheSize)
                    .addInterceptor { chain ->
                        var request = chain.request()
                        InternetCheck { internet ->
                            if (internet) {
                                request.newBuilder().header("Cache-Control", "public, max-age=" + 5)
                                    .build()
                            } else {
                                request.newBuilder().header(
                                    "Cache-Control",
                                    "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                                ).build()
                            }
                        }

                        chain.proceed(request)
                    }
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                            level = if (BuildConfig.DEBUG)
                                HttpLoggingInterceptor.Level.BODY
                            else
                                HttpLoggingInterceptor.Level.NONE
                        })
                    .readTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(ApiService::class.java)
    }

    /*fun createGoogleApi(context: Context): GoogleApiService {
        val cacheDir = File(context.cacheDir, "offlineCache")

        //10 MB
        val cacheSize = Cache(cacheDir, 10 * 1024 * 1024)

        return Retrofit.Builder()
            .baseUrl(UrlConstants.GOOGLE_BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .cache(cacheSize)
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                            level = if (BuildConfig.DEBUG)
                                HttpLoggingInterceptor.Level.BODY
                            else
                                HttpLoggingInterceptor.Level.NONE
                        })
                    .readTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(GoogleApiService::class.java)
    }*/
}