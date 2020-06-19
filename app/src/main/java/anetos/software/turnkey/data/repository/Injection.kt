package anetos.software.turnkey.data.repository

import android.content.Context
import anetos.software.turnkey.data.api.remote.RemoteDataSourceImpl

/**
 * All the viewModel Injections will go here.
 *
 *  created by jaydeepbhayani on 19/06/2020
 */
object Injection {

    fun provideDataRepository(context: Context) =
        DataRepository(
            RemoteDataSourceImpl.newInstance(context)/*,
            AppDatabase.getInstance(context)*/
        )

    /*fun provideGoogleDataRepository(context: Context) =
        GoogleDataRepository(
            GoogleRemoteDataSourceImpl.newInstance(context),
            AppDatabase.getInstance(context)
        )*/
}