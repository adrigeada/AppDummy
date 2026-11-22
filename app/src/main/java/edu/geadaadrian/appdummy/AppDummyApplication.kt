package edu.geadaadrian.appdummy

import android.app.Application
import edu.geadaadrian.appdummy.data.di.AppContainer
import edu.geadaadrian.appdummy.data.di.DefaultAppContainer

class AppDummyApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }
}