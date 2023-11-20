package com.aladin.framepro.extensions

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aladin.framepro.data.models.FrameDescription
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.ui.FramesFragment
import com.aladin.framepro.ui.NewRegisterSheet
import com.aladin.framepro.ui.RegisterFragmentDirections

class Navigation {
     fun goToFrameScreen(fragment: NewRegisterSheet, register: Register) {
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