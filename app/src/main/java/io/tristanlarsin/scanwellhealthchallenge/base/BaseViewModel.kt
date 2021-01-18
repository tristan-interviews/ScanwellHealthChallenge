package io.tristanlarsin.scanwellhealthchallenge.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<VS, A : Any> : ViewModel() {

    val viewState = MutableLiveData<VS>()

    abstract fun handleAction(action: A)
}