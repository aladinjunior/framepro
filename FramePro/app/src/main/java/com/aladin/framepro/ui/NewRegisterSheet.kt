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


class NewRegisterSheet : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewRegisterSheetBinding
    private lateinit var registerViewModel: RegisterViewModel

    private var name: String = ""
    private var address: String = ""
    private var id: Long = 0


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

                val action = RegisterFragmentDirections.actionRegisterToFrames(
                    name = this@NewRegisterSheet.name,
                    address = this@NewRegisterSheet.address,
                    id = this@NewRegisterSheet.id
                )
                findNavController().navigate(action)

            }
        }

    }


    private fun saveOnDb() {
        name = binding.name.text.toString()
        address = binding.address.text.toString()
        if (isNotEmptyData(name, address)){
            registerViewModel.viewModelScope.launch(Dispatchers.IO) {
                val register = Register(name = name, address = address)
                registerViewModel.register(register)
                this@NewRegisterSheet.id = registerViewModel.getSelectedId(name, address)
                Log.i("idTest", id.toString())




//                this@NewRegisterSheet.id = x.toString().toLong()



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