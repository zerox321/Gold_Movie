package com.gado.movieapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.gado.entity.database.respons.MovieResponseResult
import com.gado.movieapp.R
import com.gado.movieapp.base.LiveCoroutinesViewModel
import com.gado.movieapp.ui.adapter.MovieAdapter
import com.gado.movieapp.pagedList.ReservationsDataSource
import com.gado.movieapp.pagedList.ReservationsDataSourceFactory
import com.gado.movieapp.repo.MovieRepository
import com.gado.movieapp.util.navigate

class HomeViewModel(category: String, repo: MovieRepository) :
    LiveCoroutinesViewModel(),
    MovieAdapter.ClickListener {
    val adapter = MovieAdapter(this)

    private val upComingDataSourceFactory =
        ReservationsDataSourceFactory(
            viewModelScope,
            category,
            repo,
            isLoading
        )

    private val config = PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setPageSize(ReservationsDataSource.PAGE_SIZE)
        .build()

    val upComingPagedList: LiveData<PagedList<MovieResponseResult>> by lazy {
        LivePagedListBuilder(upComingDataSourceFactory, config)
            .build()
    }

    fun onRefresh() {
        upComingDataSourceFactory.invalidate()
    }

    override fun onItemClick(v: View, movie: MovieResponseResult) {
        val extras = FragmentNavigatorExtras(
            v to "view"
        )

        val args = Bundle()
        args.putParcelable("movie", movie)
        args.putString("title", movie.title)

        navigate(v, R.id.action_navigation_home_to_MovieDetailFragment,args,null,extras)

    }
}