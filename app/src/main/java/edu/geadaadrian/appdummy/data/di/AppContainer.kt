package edu.geadaadrian.appdummy.data.di

import android.content.Context
import edu.geadaadrian.appdummy.data.datasource.local.LocalDataSource
import edu.geadaadrian.appdummy.data.repository.LibrosRepository
import edu.geadaadrian.appdummy.data.datasource.local.AppDatabase
import edu.geadaadrian.appdummy.data.datasource.remote.RemoteDataSource
import edu.geadaadrian.appdummy.data.datasource.remote.RetrofitClient
import okhttp3.OkHttpClient
import kotlin.getValue

interface AppContainer {
    val librosRepository: LibrosRepository
    val okHttpClient: OkHttpClient
}

class DefaultAppContainer(context: Context) : AppContainer {

    //Local
    // Room — singleton de la base de datos
    // by lazy: se crea una sola vez la primera vez que se accede
    private val database by lazy {
        AppDatabase.getDatabase(context)
    }
    private val localDataSource: LocalDataSource by lazy {
        LocalDataSource(database.libroDao())
    }


    //Remote
    override val okHttpClient: OkHttpClient by lazy { RetrofitClient.okHttpClient }

    private val remoteDataSource: RemoteDataSource by lazy {
        RemoteDataSource(RetrofitClient.openLibraryApiService)
    }



    override val librosRepository: LibrosRepository by lazy {
        LibrosRepository(localDataSource, remoteDataSource)
    }
}