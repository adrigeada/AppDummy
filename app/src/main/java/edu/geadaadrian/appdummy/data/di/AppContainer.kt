package edu.geadaadrian.appdummy.data.di

import android.content.Context
import edu.geadaadrian.appdummy.data.datasource.local.LocalDataSource
import edu.geadaadrian.appdummy.data.repository.LibrosRepository
import edu.geadaadrian.appdummy.data.datasource.local.AppDatabase

interface AppContainer {
    val librosRepository: LibrosRepository
}

class DefaultAppContainer(context: Context) : AppContainer {

    // Room — singleton de la base de datos
    // by lazy: se crea una sola vez la primera vez que se accede
    private val database by lazy {
        AppDatabase.getDatabase(context)
    }

    private val localDataSource: LocalDataSource by lazy {
        LocalDataSource(database.libroDao())
    }

    override val librosRepository: LibrosRepository by lazy {
        LibrosRepository(localDataSource)
    }
}