package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.navArgs
import com.aladin.framepro.R
import com.aladin.framepro.data.models.FrameDescription
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.databinding.FragmentFrameSheetBinding
import com.aladin.framepro.databinding.FragmentNewRegisterSheetBinding
import com.aladin.framepro.extensions.setSheetBackground
import com.aladin.framepro.viewmodels.FrameDescriptionViewModel
import com.aladin.framepro.viewmodels.RegisterViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
            saveOnDb()
        }


    }

    private fun saveOnDb() {
        val width = binding.width.text.toString().toDouble()
        val height = binding.height.text.toString().toDouble()
        val description = binding.description.text.toString()

        if(isNotEmptyData(width, height, description)){
            frameDescViewModel.viewModelScope.launch(Dispatchers.IO) {
                val frameDesc = FrameDescription(
                    registerId = registerId,
                    width = width,
                    height = height,
                    name = name,
                    description = description
                )
                frameDescViewModel.insert(frameDesc)
            }
            Toast.makeText(requireContext(), getString(R.string.saved_successfully), Toast.LENGTH_SHORT).show()
            dismiss()
        } else {
            dismiss()
            Toast.makeText(requireContext(), getString(R.string.fields_cant_be_null), Toast.LENGTH_SHORT).show()
        }

    }

    private fun isNotEmptyData(width: Double, height: Double, description: String): Boolean {
        return width.toString().isNotEmpty() && height.toString().isNotBlank() && description.isNotEmpty()
    }

}