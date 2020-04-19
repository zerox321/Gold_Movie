package com.gado.movieapp.di

import com.gado.movieapp.repo.DetailRepository
import com.gado.movieapp.repo.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { MovieRepository(get()) }


    single { DetailRepository(get()) }


}
