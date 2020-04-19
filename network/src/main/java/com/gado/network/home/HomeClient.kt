package com.gado.network.home

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeClient(private val service: HomeService) {


    suspend fun getMovieListTask(
        category: String,
        language: String,
        page: Int
    ) = withContext(Dispatchers.IO) {
        service.getMovieListAsync(
            category = category,
            language = language,
            page = page
        ).await()
    }


}
