package com.gado.movieapp.ui.movieDetail

import androidx.lifecycle.viewModelScope
import com.gado.movieapp.base.LiveCoroutinesViewModel
import com.gado.movieapp.repo.DetailRepository
import com.gado.movieapp.ui.adapter.TrailerAdapter
import kotlinx.coroutines.launch

class MovieDetailViewModel(private val movieId: Int, private val repo: DetailRepository) :
    LiveCoroutinesViewModel() {
    val trailerAdapter = TrailerAdapter()

    init {
        getTrailers()
    }

    private fun getTrailers() {
        viewModelScope.launch {
            repo.getTrailersTaskRepo(movieId, {}, { trailerAdapter.submitList(it) })
        }
    }


}
