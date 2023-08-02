package com.example.koinbasicstructure.presenter.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.koinbasicstructure.databinding.FragmentResultBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultFragment : Fragment() {

    private val viewModel: ResultViewModel by viewModel()
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentResultBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        setListeners()
        val args: ResultFragmentArgs by navArgs()
        viewModel.getArgs(args)
    }

    private fun setObservers() {
        viewModel.action.observe(viewLifecycleOwner) { action ->
            when (action) {
                is ResultViewModel.ResultAction.ShowView -> showView(action)
                ResultViewModel.ResultAction.BackHome -> backToHome()
            }
        }
    }

    private fun setListeners() {
        binding.resultButton.setOnClickListener {
            viewModel.backToHome()
        }
    }

    private fun showView(data: ResultViewModel.ResultAction.ShowView) {
        binding.textCep.text = data.cep
        binding.textCity.text = data.neighborhood
        binding.textNeighborhood.text = data.neighborhood
        binding.textStreet.text = data.street
    }

    private fun backToHome() {
        findNavController().navigate(ResultFragmentDirections.resultBackToHome())
    }
}