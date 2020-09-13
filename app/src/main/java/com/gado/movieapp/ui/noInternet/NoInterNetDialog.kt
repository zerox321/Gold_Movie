package com.gado.movieapp.ui.noInternet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gado.movieapp.R
import com.gado.movieapp.base.DataBindingDialog
import com.gado.movieapp.databinding.NoInterNetDialogBinding
import com.gado.movieapp.util.isConnected
import com.gado.movieapp.util.shake

class NoInterNetDialog : DataBindingDialog() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<NoInterNetDialogBinding>(
            inflater, R.layout.no_inter_net_dialog, container
        ).apply {
            lifecycleOwner = this@NoInterNetDialog
            this@NoInterNetDialog.isCancelable = false
            this.executePendingBindings()
            reloadTv.setOnClickListener {
                if (isConnected(this@NoInterNetDialog.requireContext()))
                    this@NoInterNetDialog.dismissAllowingStateLoss()
                else
                    shake(this@NoInterNetDialog.requireView())
            }
        }.root
    }

}

