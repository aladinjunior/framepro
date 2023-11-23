package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.aladin.framepro.adapters.ResultsAdapter
import com.aladin.framepro.databinding.FragmentResultsBinding


class ResultsFragment : Fragment() {

    private lateinit var binding: FragmentResultsBinding

    private val adapter by lazy {
        ResultsAdapter()
    }

    private val args: ResultsFragmentArgs by navArgs()

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

        binding.resultsRv.layoutManager = LinearLayoutManager(requireContext())
        binding.resultsRv.adapter = adapter
        adapter.setList(args.register.frames)


    }

}