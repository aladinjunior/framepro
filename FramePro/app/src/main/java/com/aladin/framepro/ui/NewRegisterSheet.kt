package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.aladin.framepro.data.db.instructions.DbInstBase
import com.aladin.framepro.data.db.instructions.DbInstDataSource
import com.aladin.framepro.data.db.instructions.DbInstructionsImpl
import com.aladin.framepro.databinding.FragmentNewRegisterSheetBinding
import com.aladin.framepro.extensions.Navigation
import com.aladin.framepro.extensions.setSheetBackground
import com.aladin.framepro.viewmodels.RegisterViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NewRegisterSheet(private val dbInstructions: DbInstBase = DbInstDataSource(DbInstructionsImpl())) : BottomSheetDialogFragment() {

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

                val register = dbInstructions.saveOnRegisterDb(
                    this@NewRegisterSheet,
                    registerViewModel,
                    this@NewRegisterSheet.name,
                    this@NewRegisterSheet.address
                )
                Navigation().goToFrameScreen(this@NewRegisterSheet, registerViewModel, register)


//                registerViewModel.registerId.observe(viewLifecycleOwner) { registerId ->
//                    val action = RegisterFragmentDirections.actionRegisterToFrames(
//                        name = register.name,
//                        address = register.address,
//                        id = registerId
//                    )
//                    findNavController().navigate(action)
//                val action = RegisterFragmentDirections.actionRegisterToFrames(
//                    name = this@NewRegisterSheet.name,
//                    address = this@NewRegisterSheet.address,
//                    id = this@NewRegisterSheet.id.toLong()
//                )
//                findNavController().navigate(action)
            }
        }

    }


}