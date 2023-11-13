package com.aladin.framepro.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.aladin.framepro.R
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.data.models.RegisterEntity
import com.aladin.framepro.databinding.FragmentNewRegisterSheetBinding
import com.aladin.framepro.extensions.map
import com.aladin.framepro.extensions.setSheetBackground
import com.aladin.framepro.viewmodels.RegisterViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


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
                saveOnDb()


            }
        }

    }


    private fun saveOnDb() {
        name = binding.name.text.toString()
        address = binding.address.text.toString()



        if (isNotEmptyData(name, address)) {

            val register = Register(name = name, address = address)
            registerViewModel.register(register)

            registerViewModel.registerId.observe(viewLifecycleOwner) { registerId ->
                val action = RegisterFragmentDirections.actionRegisterToFrames(
                    name = register.name,
                    address = register.address,
                    id = registerId
                )
                findNavController().navigate(action)
                dismiss()

                dismiss()
            }

        } else {
            dismiss()
            Toast.makeText(
                requireContext(),
                getString(R.string.fields_cant_be_null),
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    private fun isNotEmptyData(name: String, address: String): Boolean {
        return name.isNotEmpty() && name.isNotBlank() && address.isNotEmpty() && address.isNotBlank()
    }

}