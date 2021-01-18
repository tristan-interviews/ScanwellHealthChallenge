package io.tristanlarsin.scanwellhealthchallenge.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<VS, A : Any> : ViewModel() {

    val viewState = SingleLiveEvent<VS>()

    abstract fun handleAction(action: A)
}