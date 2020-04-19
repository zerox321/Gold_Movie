package com.gado.movieapp.di

import com.gado.movieapp.ui.dashboard.DashboardViewModel
import com.gado.movieapp.ui.home.HomeViewModel
import com.gado.movieapp.ui.movieDetail.MovieDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { (category: String) -> HomeViewModel(category, get()) }
    viewModel { (category: String) -> DashboardViewModel(category, get()) }
    viewModel { (movieId: Int) -> MovieDetailViewModel(movieId, get()) }


}
