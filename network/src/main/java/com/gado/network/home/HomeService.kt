package com.gado.network.home

import com.gado.entity.database.respons.MovieResponse
import com.gado.entity.database.respons.TrailerResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HomeService {

    @GET("3/movie/{category}")
    fun getMovieListAsync(
        @Path("category") category: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Deferred<MovieResponse>

 @GET("3/movie/{id}/{videos}")
    fun getTrailersAsync(
        @Path("id") id: String,
        @Path("videos") videos: String
    ): Deferred<TrailerResponse>


}
