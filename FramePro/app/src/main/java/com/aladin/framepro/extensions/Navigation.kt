package com.aladin.framepro.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.ui.FramesFragment
import com.aladin.framepro.ui.NewRegisterSheet
import com.aladin.framepro.ui.RegisterFragmentDirections
import com.aladin.framepro.viewmodels.RegisterViewModel
import kotlinx.coroutines.launch

class Navigation {
     fun goToFrameScreen(fragment: NewRegisterSheet, registerViewModel: RegisterViewModel, register: Register) {
//         val observer = Observer<Long> { registerId ->
//             val action = RegisterFragmentDirections.actionRegisterToFrames(
//                 register = register
//             )
//
//             fragment.viewLifecycleOwner.lifecycleScope.launch {
//                 fragment.findNavController().navigate(action)
//             }
//
//             registerViewModel.registerId.removeObservers(fragment.viewLifecycleOwner)
//         }
//
//         registerViewModel.registerId.observe(fragment.viewLifecycleOwner, observer)
         val action = RegisterFragmentDirections.actionRegisterToFrames(register)
         fragment.findNavController().navigate(action)
     }


    fun goToRegisterScreen(fragment: FramesFragment) {
        fragment.findNavController().popBackStack()
    }

    fun goToResultScreen(fragment: Fragment, register: Register){
        val action = RegisterFragmentDirections.actionRegisterToResults(register)
        fragment.findNavController().navigate(action)
    }
}