package com.gado.movieapp.repo

import com.gado.entity.database.respons.TrailerResponseResult
import com.gado.network.detail.DetailClient
import timber.log.Timber

class DetailRepository constructor(
    private val retrofitClient: DetailClient
) {

    suspend fun getTrailersTaskRepo(
        id: Int,
        onLoading: (Boolean) -> Unit,
        onResult: (List<TrailerResponseResult>?) -> Unit

    ) {
        Timber.e("getTrailersTaskRepo start")
        onLoading(true)
        try {
            val response = retrofitClient.getTrailersTask(
                id = id

            )

            Timber.e("getTrailersTaskRepo   $response")

            onResult(response.results)


        } catch (t: Throwable) {
            Timber.e("getTrailersTaskRepo ex  ${t.message}")

        }
        onLoading(false)

        Timber.e("getTrailersTaskRepo finish")

    }

}