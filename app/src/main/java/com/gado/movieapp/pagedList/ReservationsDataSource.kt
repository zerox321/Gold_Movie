package com.gado.movieapp.pagedList

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.gado.entity.database.respons.MovieResponseResult
import com.gado.movieapp.repo.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ReservationsDataSource(
    private val viewModelScope: CoroutineScope,
    private val category: String,
    private val repo: MovieRepository,
    private val loading: MutableLiveData<Boolean>

) : PageKeyedDataSource<Int, MovieResponseResult>() {
    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, MovieResponseResult>
    ) {

        viewModelScope.launch {
            repo.getMovieListTaskRepo(
                category,
                "en",
                params.key, { loading.postValue(it) }
            ) { reviewsList ->
                val key = if (params.key > 1) params.key - 1 else 0
                reviewsList?.let {
                    callback.onResult(reviewsList, key)
                }

            }

        }

    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, MovieResponseResult>
    ) {
        viewModelScope.launch {
            repo.getMovieListTaskRepo(
                category,
                "en",
                FIRST_PAGE, { loading.postValue(it) }
            ) { reviewsList ->
                reviewsList?.let {
                    callback.onResult(reviewsList, null, FIRST_PAGE + 1)
                }

            }

        }

    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, MovieResponseResult>
    ) {
        viewModelScope.launch {
            repo.getMovieListTaskRepo(
                category,
                "en",
                params.key, { loading.postValue(it) }
            ) { reviewsList ->
                reviewsList?.let {
                    callback.onResult(reviewsList, params.key + 1)
                }

            }

        }


    }

    companion object {
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 1
    }
}