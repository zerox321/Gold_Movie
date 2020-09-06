package com.gado.movieapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.gado.movieapp.R
import com.gado.movieapp.base.DataBindingFragment
import com.gado.movieapp.databinding.FragmentHomeBinding
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.core.parameter.parametersOf

class HomeFragment : DataBindingFragment() {
    private val homeViewModel by sharedViewModel<HomeViewModel>(from = { parentFragment!! }){ parametersOf("popular") }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container
        ).apply {
            viewModel = this@HomeFragment.homeViewModel
            lifecycleOwner = this@HomeFragment
            recyclerViewOnPreDraw(listView)
            executePendingBindings()
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.upComingPagedList.observe(this.viewLifecycleOwner, Observer {
            homeViewModel.adapter.submitList(it)
        })
    }
}
