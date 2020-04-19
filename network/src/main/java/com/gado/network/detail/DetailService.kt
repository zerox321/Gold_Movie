package com.gado.network.detail

import com.gado.entity.database.respons.TrailerResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailService {


    @GET("3/movie/{id}/{videos}")
    fun getTrailersAsync(
        @Path("id") id: Int,
        @Path("videos") videos: String
    ): Deferred<TrailerResponse>


}
