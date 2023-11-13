package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.aladin.framepro.data.repositories.DbImplementation
import com.aladin.framepro.databinding.FragmentNewRegisterSheetBinding
import com.aladin.framepro.extensions.Navigation
import com.aladin.framepro.extensions.setSheetBackground
import com.aladin.framepro.viewmodels.RegisterViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NewRegisterSheet : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewRegisterSheetBinding
    private lateinit var registerViewModel: RegisterViewModel

    private var name: String = ""
    private var address: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewRegisterSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSheetBackground()
        registerViewModel = ViewModelProvider(requireActivity())[RegisterViewModel::class.java]
        with(binding) {
            saveBttn.setOnClickListener {
                this@NewRegisterSheet.name = binding.name.text.toString()
                this@NewRegisterSheet.address = binding.address.text.toString()
                val register = DbImplementation().saveOnRegisterDb(
                    this@NewRegisterSheet,
                    registerViewModel,
                    this@NewRegisterSheet.name,
                    this@NewRegisterSheet.address
                )
                Navigation().goToFrameScreen(this@NewRegisterSheet, registerViewModel, register)


            }
        }

    }


}