package anetos.software.turnkey.core.helper

import android.content.Context
import anetos.software.turnkey.BuildConfig
import anetos.software.turnkey.core.InternetCheck
import anetos.software.turnkey.data.UrlConstants
import anetos.software.turnkey.data.api.ApiService
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.IOException

object NetworkHelper {

    fun create(context: Context): ApiService {

        val httpCacheDirectory = File(context.cacheDir, "offlineCache")

        //10 MB
        val cache = okhttp3.Cache(httpCacheDirectory, 10 * 1024 * 1024)

        val httpClient = OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(HttpLoggingInterceptor()
                .apply {
                    level = if (BuildConfig.DEBUG)
                        HttpLoggingInterceptor.Level.BODY
                    else
                        HttpLoggingInterceptor.Level.NONE
                })
            .addNetworkInterceptor(REWRITE_RESPONSE_INTERCEPTOR)
            .addInterceptor(REWRITE_RESPONSE_INTERCEPTOR_OFFLINE)
            .build()

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(httpClient)
            .baseUrl(UrlConstants.BASE_URL)
            .build()

        return retrofit.create(ApiService::class.java)
    }

    private val REWRITE_RESPONSE_INTERCEPTOR = object : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            val originalResponse = chain.proceed(chain.request())
            val cacheControl = originalResponse.header("Cache-Control")
            return if (cacheControl == null ||
                cacheControl.contains("no-store") ||
                cacheControl.contains("no-cache") ||
                cacheControl.contains("must-revalidate") ||
                cacheControl.contains("max-age=0")
            ) {
                originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, max-age=" + 5000)
                    .build()
            } else {
                originalResponse
            }
        }
    }

    private val REWRITE_RESPONSE_INTERCEPTOR_OFFLINE = object : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            var request = chain.request()

            InternetCheck {
                if (!it) {
                    request = request.newBuilder()
                        //.removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached")
                        .build()
                }
            }

            return chain.proceed(request)
        }
    }
}