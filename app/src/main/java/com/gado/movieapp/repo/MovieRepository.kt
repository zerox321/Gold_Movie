package com.gado.movieapp.repo

import com.gado.entity.database.respons.MovieResponseResult
import com.gado.network.home.HomeClient
import timber.log.Timber

class MovieRepository constructor(
    private val retrofitClient: HomeClient
) {

    suspend fun getMovieListTaskRepo(
        category: String,
        language: String,
        page: Int,
        onLoading: (Boolean) -> Unit,
        onResult: (List<MovieResponseResult>?) -> Unit

    ) {
        Timber.e("getMovieListTaskRepo start")
        onLoading(true)
        try {
            val response = retrofitClient.getMovieListTask(
                    category = category,
                    language = language,
                    page = page
                )

            Timber.e("getMovieListTaskRepo   $response")

            onResult(response.results)


        } catch (t: Throwable) {
            Timber.e("getMovieListTaskRepo finish  ${t.message}")

        }
        onLoading(false)

        Timber.e("getMovieListTaskRepo finish")

    }

}