package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.aladin.framepro.adapters.ResultsAdapter
import com.aladin.framepro.databinding.FragmentResultsBinding
import com.aladin.framepro.viewmodel.ResultsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ResultsFragment : Fragment() {

    private lateinit var binding: FragmentResultsBinding

    private val adapter by lazy {
        ResultsAdapter()
    }

    private val args: ResultsFragmentArgs by navArgs()

    private val viewModel: ResultsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            with(args.register){
                resultsRv.layoutManager = LinearLayoutManager(requireContext())
                resultsRv.adapter = adapter
                registerName.text = name.uppercase()
                adapter.setList(frames)

                pdfBttn.setOnClickListener {
                    try {
                        viewModel.createPdf(requireContext(), this)
                    } catch (e: FileSystemException) {
                        e.printStackTrace()
                    }
                }
                }
        }



    }

}