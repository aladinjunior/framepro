package com.aladin.framepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.aladin.framepro.R
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.databinding.FragmentNewRegisterSheetBinding
import com.aladin.framepro.util.Navigation
import com.aladin.framepro.extensions.setSheetBackground
import com.aladin.framepro.extensions.showToast
import com.aladin.framepro.viewmodels.RegisterViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class NewRegisterSheet @Inject constructor(
    private val navigation: Navigation,
) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewRegisterSheetBinding
    private val viewModel: RegisterViewModel by viewModels()

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
        with(binding) {
            saveBttn.setOnClickListener {
                with(this@NewRegisterSheet){
                    name = binding.name.text.toString()
                    address = binding.address.text.toString()

                    val register = Register(name = name, address = address)

                    if (viewModel.emptyFieldError(name, address)) showToast(getString(R.string.fields_cant_be_null))
                    else navigation.goToFrameScreen(this, register)
                    dismiss()

                }



            }
        }

    }


}