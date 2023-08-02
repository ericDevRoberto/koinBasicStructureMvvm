package com.example.koinbasicstructure.presenter.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.koinbasicstructure.R
import com.example.koinbasicstructure.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHomeBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        setListeners()
    }

    private fun setObservers() {
        viewModel.action.observe(viewLifecycleOwner) { action ->
            when (action) {
                HomeViewModel.HomeAction.ApiFail -> showError()
                is HomeViewModel.HomeAction.OpenResultView -> openResultView(action)
            }
        }

        viewModel.actionLoading.observe(viewLifecycleOwner) { action ->
            when (action) {
                HomeViewModel.HomeLoading.LoadingOff -> loadingOff()
                HomeViewModel.HomeLoading.LoadingOn -> loadingOn()
            }
        }
    }

    private fun setListeners() {
        binding.homeButton.setOnClickListener {
            viewModel.clickToSearchCep()
        }
        binding.homeEditText.addTextChangedListener {
            viewModel.getCep(it.toString())
        }
    }

    private fun loadingOn() {
        binding.homeButton.visibility = View.GONE
        binding.homeProgress.visibility = View.VISIBLE
    }

    private fun loadingOff() {
        binding.homeProgress.visibility = View.GONE
        binding.homeButton.visibility = View.VISIBLE
    }

    private fun showError() {
        Toast.makeText(context, getString(R.string.home_error_api), Toast.LENGTH_LONG).show()
    }

    private fun openResultView(action: HomeViewModel.HomeAction.OpenResultView) {
        findNavController().navigate(HomeFragmentDirections.homeToResult(action.data))
    }
}