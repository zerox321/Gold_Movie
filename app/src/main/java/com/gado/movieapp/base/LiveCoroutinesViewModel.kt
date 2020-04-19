package com.gado.movieapp.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class LiveCoroutinesViewModel : ViewModel() {
    val isLoading = MutableLiveData(false)


}
