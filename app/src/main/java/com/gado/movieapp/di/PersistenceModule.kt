package com.gado.movieapp.di

import androidx.room.Room
import com.gado.entity.database.AppDatabase
import com.gado.entity.database.counrtyController.CountryController
import com.gado.movieapp.R

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val persistenceModule = module {

    single {
        Room
            .databaseBuilder(
                androidApplication(), AppDatabase::class.java,
                androidApplication().getString(R.string.database)
            )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().countryDao() }
    single { CountryController(get()) }



}
