package com.aladin.framepro.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.aladin.framepro.R
import com.aladin.framepro.data.models.FrameView
import com.aladin.framepro.databinding.FragmentCreateFrameSheetBinding
import com.aladin.framepro.extensions.resourcesToUri
import com.aladin.framepro.extensions.setSheetBackground
import com.aladin.framepro.extensions.showToast
import com.aladin.framepro.viewmodel.AddFrameViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateFrameSheet(
    private val viewModel: AddFrameViewModel,
    private val onCreatedFrameClick: (frameView: FrameView) -> Unit) : BottomSheetDialogFragment(){


    private lateinit var binding: FragmentCreateFrameSheetBinding


    private var name: String = ""
    private var material: String = ""
    private lateinit var imageUri: Uri

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let{
            imageUri = it
        }
    }

    override fun onAttach(context: Context) {
        imageUri = resourcesToUri(requireContext(), R.drawable.b)
        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateFrameSheetBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSheetBackground()



        with(binding) {

            pickImageButton.setOnClickListener {
                pickImage()
            }

            saveBttn.setOnClickListener {
                with(this@CreateFrameSheet) {

                    name = binding.name.text.toString()
                    material = binding.material.text.toString()
                    val frameView = FrameView(imageUri, name, material)

                    if (!viewModel.emptyAddFieldError(name, material)){
                        showToast(getString(R.string.fields_cant_be_null))
                        dismiss()
                    } else {
                        onCreatedFrameClick(frameView)
                        dismiss()
                    }

                }


            }
        }

    }

    private fun pickImage() = getContent.launch("image/*")

}