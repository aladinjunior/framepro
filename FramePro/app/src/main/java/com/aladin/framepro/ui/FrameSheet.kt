package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.aladin.framepro.data.repositories.DbImplementation
import com.aladin.framepro.databinding.FragmentFrameSheetBinding
import com.aladin.framepro.extensions.setSheetBackground
import com.aladin.framepro.viewmodels.FrameDescriptionViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FrameSheet(private val name: String, private val registerId: Long) :
    BottomSheetDialogFragment() {

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

        binding.saveBttn.setOnClickListener {
            with(binding) {
                val width = width.text.toString().toDouble()
                val height = height.text.toString().toDouble()
                val description = description.text.toString()
                DbImplementation().saveOnFrameDb(
                    this@FrameSheet,
                    frameDescViewModel,
                    name,
                    registerId,
                    width,
                    height,
                    description
                )
            }

        }


    }


}