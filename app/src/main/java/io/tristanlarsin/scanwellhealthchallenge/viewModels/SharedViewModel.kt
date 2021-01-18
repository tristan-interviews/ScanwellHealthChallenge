package io.tristanlarsin.scanwellhealthchallenge.viewModels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import io.tristanlarsin.scanwellhealthchallenge.repositories.DataRepository
import io.tristanlarsin.scanwellhealthchallenge.viewModels.SharedViewModel.Action
import io.tristanlarsin.scanwellhealthchallenge.viewModels.SharedViewModel.ViewState
import io.tristanlarsin.scanwellhealthchallenge.base.BaseViewModel

class SharedViewModel @ViewModelInject constructor(
    private val repo: DataRepository
) : BaseViewModel<ViewState, Action>() {

    val currentRandomString : LiveData<String?>
        get() = repo.currentRandomString

    override fun handleAction(action: Action) {
        when (action) {
            Action.OnGenerateRandomStringClick -> onGenerateRandomStringClick()
            Action.OnNavigateToSecondFragmentClick -> onNavigateToSecondFragmentClick()

            Action.OnNavigateToFirstFragmentClick -> onNavigateToFirstFragmentClick()
        }
    }

    private fun onGenerateRandomStringClick() {
        repo.generateRandomString()
    }

    private fun onNavigateToSecondFragmentClick() {
        viewState.value = ViewState.NavigateToSecondFragment
    }

    private fun onNavigateToFirstFragmentClick() {
        viewState.value = ViewState.NavigateToFirstFragment
    }

    sealed class Action  {
        object OnNavigateToSecondFragmentClick : Action()
        object OnGenerateRandomStringClick : Action()

        object OnNavigateToFirstFragmentClick : Action()
    }

    sealed class ViewState {
        object NavigateToSecondFragment : ViewState()
        object NavigateToFirstFragment : ViewState()
    }
}