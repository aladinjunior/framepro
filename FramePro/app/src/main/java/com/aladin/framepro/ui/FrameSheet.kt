package com.aladin.framepro.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.aladin.framepro.R
import com.aladin.framepro.data.models.FrameDescription
import com.aladin.framepro.databinding.FragmentFrameSheetBinding
import com.aladin.framepro.extensions.setSheetBackground
import com.aladin.framepro.extensions.showToast
import com.aladin.framepro.viewmodels.FrameDescriptionViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FrameSheet(
    private val name: String,
    val list: MutableList<FrameDescription> = mutableListOf()
) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentFrameSheetBinding

    private val frameDescViewModel by lazy {
        ViewModelProvider(requireActivity())[FrameDescriptionViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFrameSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSheetBackground()



        frameDescViewModel.saved(false)
        binding.saveBttn.setOnClickListener {
            with(binding) {
                if (width.text?.isNotEmpty() == true && height.text?.isNotEmpty() == true) {

                    val frameDescription = FrameDescription(
                        name = name,
                        width = width.text.toString().toDouble(),
                        height = height.text.toString().toDouble(),
                        description = description.text.toString())


                     frameDescViewModel.addFrameDescToList(frameDescription)

                    frameDescViewModel.listOfFrames.value?.let {
                        list.addAll(it)
                        Log.i("listOfFrames", it.toString())
                    }


                    dismiss()

                    frameDescViewModel.saved(true)
                } else {
                    dismiss()
                    showToast(getString(R.string.fields_cant_be_null))
                }

            }

        }


    }


}