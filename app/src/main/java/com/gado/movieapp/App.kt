package com.gado.movieapp

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.jakewharton.threetenabp.AndroidThreeTen
import com.gado.movieapp.di.networkModule
import com.gado.movieapp.di.persistenceModule
import com.gado.movieapp.di.repositoryModule
import com.gado.movieapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber


@Suppress("unused")
class App : MultiDexApplication() {
    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)
        startKoin {

            androidContext(this@App)

            modules(networkModule)

            modules(persistenceModule)

            modules(repositoryModule)

            modules(viewModelModule)
        }

        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())


    }
}
