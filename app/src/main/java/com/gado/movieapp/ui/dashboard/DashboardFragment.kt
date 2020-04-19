package com.gado.movieapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.gado.movieapp.R
import com.gado.movieapp.base.DataBindingFragment
import com.gado.movieapp.databinding.FragmentDashboardBinding
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.core.parameter.parametersOf

class DashboardFragment : DataBindingFragment() {
    private val dashboardViewModel by sharedViewModel<DashboardViewModel>(from = { parentFragment!! }) {
        parametersOf(
            "top_rated"
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentDashboardBinding>(
            inflater, R.layout.fragment_dashboard, container
        ).apply {
            viewModel = this@DashboardFragment.dashboardViewModel
            lifecycleOwner = this@DashboardFragment
            executePendingBindings()
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dashboardViewModel.upComingPagedList.observe(this.viewLifecycleOwner, Observer {
            dashboardViewModel.adapter.submitList(it)
        })
    }
}

