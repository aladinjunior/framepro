package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.aladin.framepro.R
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.databinding.FragmentNewRegisterSheetBinding
import com.aladin.framepro.extensions.setSheetBackground
import com.aladin.framepro.viewmodels.RegisterViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


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
        with(binding) {
            saveBttn.setOnClickListener {
                saveOnDb()

            }
        }

    }


    private fun saveOnDb() {
        val name = binding.name.text.toString()
        val address = binding.address.text.toString()
        if (isNotEmptyData(name, address)){
            registerViewModel.viewModelScope.launch(Dispatchers.IO) {
                val register = Register(name = name, address = address)
                registerViewModel.register(register)
            }
            dismiss()
        } else {
            dismiss()
            Toast.makeText(requireContext(), getString(R.string.fields_cant_be_null), Toast.LENGTH_SHORT).show()
        }

    }

    private fun isNotEmptyData(name: String, address: String): Boolean {
        return name.isNotEmpty() && name.isNotBlank() && address.isNotEmpty() && address.isNotBlank()
    }


}