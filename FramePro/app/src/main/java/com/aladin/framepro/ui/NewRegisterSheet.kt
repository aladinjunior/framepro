package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.aladin.framepro.R
import com.aladin.framepro.databinding.FragmentNewRegisterSheetBinding
import com.aladin.framepro.setSheetBackground
import com.aladin.framepro.viewmodels.RegisterViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NewRegisterSheet : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewRegisterSheetBinding
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewRegisterSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSheetBackground()
        val activity = requireActivity()
        registerViewModel = ViewModelProvider(activity)[RegisterViewModel::class.java]
        with(binding){
            val name = name.text.toString()
            val address = address.text.toString()
            saveBttn.setOnClickListener {
                register(name, address)
            }
        }



    }

    private fun register(name: String, address: String){
        registerViewModel.register(name, address)
        dismiss()
    }


}