package com.gado.network.detail

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailClient(private val service: DetailService) {


    suspend fun getTrailersTask(id: Int) = withContext(Dispatchers.IO) {
        service.getTrailersAsync(
            id = id,
            videos = "videos"
        ).await()
    }


}
