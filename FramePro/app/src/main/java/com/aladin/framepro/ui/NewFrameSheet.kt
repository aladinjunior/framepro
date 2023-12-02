package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.aladin.framepro.data.models.FrameView
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.databinding.FragmentNewFrameSheetBinding
import com.aladin.framepro.extensions.setSheetBackground
import com.aladin.framepro.extensions.showToast
import com.aladin.framepro.util.Navigation
import com.aladin.framepro.viewmodel.AddFrameViewModel
import com.aladin.framepro.viewmodel.RegisterViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewFrameSheet(
    private val navigation: Navigation
) : BottomSheetDialogFragment(){


    private lateinit var binding: FragmentNewFrameSheetBinding
    private val viewModel: AddFrameViewModel by viewModels()

    private var name: String = ""
    private var material: String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewFrameSheetBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSheetBackground()
        with(binding) {

            saveBttn.setOnClickListener {
                with(this@NewFrameSheet) {
                    name = binding.name.text.toString()
                    material = binding.material.text.toString()


//                    val frameView = FrameView(name = name, subtitle = material, imgCo)
//
                    if (viewModel.emptyAddFieldError(name, material))
                        showToast(getString(com.aladin.framepro.R.string.fields_cant_be_null))
                    dismiss()

                }


            }
        }

    }

}