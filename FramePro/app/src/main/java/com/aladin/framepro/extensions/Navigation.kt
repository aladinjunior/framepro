package com.aladin.framepro.extensions

import androidx.navigation.fragment.findNavController
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.ui.RegisterFragmentDirections
import com.aladin.framepro.viewmodels.RegisterViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Navigation {
     fun goToFrameScreen(sheetRegister: BottomSheetDialogFragment,registerViewModel: RegisterViewModel, register: Register) {
        registerViewModel.registerId.observe(sheetRegister.viewLifecycleOwner) { registerId ->
            val action = RegisterFragmentDirections.actionRegisterToFrames(
                name = register.name,
                address = register.address,
                id = registerId
            )
            sheetRegister.findNavController().navigate(action)

        }
    }
}