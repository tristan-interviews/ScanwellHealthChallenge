package io.tristanlarsin.scanwellhealthchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import io.tristanlarsin.scanwellhealthchallenge.R
import io.tristanlarsin.scanwellhealthchallenge.viewModels.SharedViewModel
import io.tristanlarsin.scanwellhealthchallenge.viewModels.SharedViewModel.Action
import io.tristanlarsin.scanwellhealthchallenge.viewModels.SharedViewModel.ViewState
import io.tristanlarsin.scanwellhealthchallenge.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : BaseFragment() {

    private val viewModel: SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_second, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attachListeners()
    }

    private fun attachListeners() {
        viewModel.viewState.observe(viewLifecycleOwner, { viewState ->
            handleViewState(viewState)
        })

        viewModel.currentRandomString.observe(viewLifecycleOwner, { randomString ->
            tv_string.text = randomString ?: getString(R.string.fragment_second_default_text)
        })

        btn_previous.setOnClickListener {
            viewModel.handleAction(Action.OnNavigateToFirstFragmentClick)
        }
    }

    private fun handleViewState(viewState: ViewState) {
        when (viewState) {
            is ViewState.NavigateToFirstFragment -> navigateToFirstFragment()
        }
    }

    private fun navigateToFirstFragment() {
        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
    }
}