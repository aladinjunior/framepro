package com.aladin.framepro.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.aladin.framepro.adapters.ResultsAdapter
import com.aladin.framepro.databinding.FragmentResultsBinding
import com.aladin.framepro.extensions.showToast
import com.aladin.framepro.viewmodels.FrameDescriptionViewModel

class ResultsFragment : Fragment() {

    private lateinit var binding: FragmentResultsBinding

    private val adapter by lazy {
        ResultsAdapter()
    }

    private val frameDescViewModel by lazy {
        ViewModelProvider(requireActivity())[FrameDescriptionViewModel::class.java]
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

//        frameDescViewModel.getFrameDescription(args.frames)

        showToast(args.register.toString())



//        frameDescViewModel.listOfFrames.value?.let {
////            adapter.setList(it)
////            showToast(it.toString())
//        }
        frameDescViewModel.listOfFrames.observe(viewLifecycleOwner){
            showToast(it.toString())
        }
//        Log.i("listOfFrames", args.register.frames.toString())

//        showToast(args.register.frames.toString())
//        frameDescViewModel.listOfFrames.observe(viewLifecycleOwner) {
//            args.register
//            adapter.setList(it)
//        }


    }

}