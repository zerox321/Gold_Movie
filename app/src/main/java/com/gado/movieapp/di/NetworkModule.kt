package com.gado.movieapp.di

import com.gado.network.EndPoint
import com.gado.network.RequestInterceptor
import com.gado.network.detail.DetailClient
import com.gado.network.detail.DetailService
import com.gado.network.home.HomeClient
import com.gado.network.home.HomeService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .connectTimeout(EndPoint.timeOut, TimeUnit.SECONDS)
            .readTimeout(EndPoint.timeOut, TimeUnit.SECONDS)
            .writeTimeout(EndPoint.timeOut, TimeUnit.SECONDS)
            .build()
    }
    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(EndPoint.Url)
            .addConverterFactory(MoshiConverterFactory.create(get<Moshi>()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }




    single { get<Retrofit>().create(HomeService::class.java) }
    single { HomeClient(get()) }

    single { get<Retrofit>().create(DetailService::class.java) }
    single { DetailClient(get()) }


}
