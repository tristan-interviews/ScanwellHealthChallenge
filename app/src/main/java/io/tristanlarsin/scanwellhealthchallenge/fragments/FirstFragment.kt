package io.tristanlarsin.scanwellhealthchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import io.tristanlarsin.scanwellhealthchallenge.R
import io.tristanlarsin.scanwellhealthchallenge.viewModels.SharedViewModel
import io.tristanlarsin.scanwellhealthchallenge.viewModels.SharedViewModel.*
import io.tristanlarsin.scanwellhealthchallenge.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : BaseFragment() {

    private val viewModel: SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_first, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attachListeners()
    }

    private fun attachListeners() {
        viewModel.viewState.observe(viewLifecycleOwner, { viewState ->
            handleViewState(viewState)
        })

        viewModel.currentRandomString.observe(viewLifecycleOwner, { randomString ->
            tv_string.text = randomString ?: getString(R.string.fragment_first_default_text)
        })

        btn_generate.setOnClickListener {
            viewModel.handleAction(Action.OnGenerateRandomStringClick)
        }

        btn_next.setOnClickListener {
            viewModel.handleAction(Action.OnNavigateToSecondFragmentClick)
        }
    }

    private fun handleViewState(viewState: ViewState) {
        when (viewState) {
            is ViewState.NavigateToSecondFragment -> navigateToSecondFragment()
        }
    }

    private fun navigateToSecondFragment() {
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}