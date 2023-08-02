package com.example.koinbasicstructure.presenter.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.koinbasicstructure.databinding.FragmentResultBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultFragment : Fragment() {

    private val viewModel: ResultViewModel by viewModel()
    private var _binding: FragmentResultBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
                ResultViewModel::class.java
            )

        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCepLabel
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}