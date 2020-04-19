package com.gado.movieapp.pagedList

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.gado.entity.database.respons.MovieResponseResult
import com.gado.movieapp.repo.MovieRepository
import kotlinx.coroutines.CoroutineScope

class ReservationsDataSourceFactory(
    private val viewModelScope: CoroutineScope,
    private val category: String,
    private val repo: MovieRepository,
    private val loading: MutableLiveData<Boolean>
) : DataSource.Factory<Int, MovieResponseResult>() {
    private val userLiveDataSource = MutableLiveData<ReservationsDataSource>()
    override fun create(): DataSource<Int, MovieResponseResult> {
        val userDataSource =
            ReservationsDataSource(
                viewModelScope,
                category,
                repo,
                loading
            )
        userLiveDataSource.postValue(userDataSource)
        return userDataSource
    }

    fun invalidate() {
        this.userLiveDataSource.value?.invalidate()
    }
}