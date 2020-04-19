package com.gado.movieapp.ui.movieDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.gado.movieapp.R
import com.gado.movieapp.base.DataBindingFragment
import com.gado.movieapp.databinding.MovieDetailFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MovieDetailFragment : DataBindingFragment() {

    private val args: MovieDetailFragmentArgs by navArgs()

    private val movieDetailViewModel by viewModel<MovieDetailViewModel> { parametersOf(args.movie?.id) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<MovieDetailFragmentBinding>(
            inflater, R.layout.movie_detail_fragment, container
        ).apply {
            viewModel = this@MovieDetailFragment.movieDetailViewModel
            movie = args.movie
            lifecycleOwner = this@MovieDetailFragment
            executePendingBindings()
        }.root
    }


}
