package com.aladin.framepro.data.repositories

import android.widget.Toast
import androidx.lifecycle.viewModelScope
import com.aladin.framepro.R
import com.aladin.framepro.data.models.FrameDescription
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.extensions.Navigation
import com.aladin.framepro.extensions.Validations
import com.aladin.framepro.extensions.showToast
import com.aladin.framepro.viewmodels.FrameDescriptionViewModel
import com.aladin.framepro.viewmodels.RegisterViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DbImplementation {

     fun saveOnRegisterDb(sheetFragment: BottomSheetDialogFragment, registerViewModel: RegisterViewModel, name: String, address: String) : Register {

         return if (Validations().isNotEmptyData(name, address)) {
             val register = Register(name = name, address = address)
             registerViewModel.register(register)
             sheetFragment.dismiss()
             register

         } else {
             with(sheetFragment){
                 dismiss()
                 showToast(sheetFragment.getString(R.string.fields_cant_be_null))
             }
             Register()
         }
    }

     fun saveOnFrameDb(sheetFragment: BottomSheetDialogFragment, frameDescViewModel: FrameDescriptionViewModel, name: String, registerId: Long,  width: Double, height: Double, description: String) {

        if(Validations().isNotEmptyData(width, height, description)){
            frameDescViewModel.viewModelScope.launch(Dispatchers.IO) {
                val frameDesc = FrameDescription(
                    registerId = registerId,
                    width = width,
                    height = height,
                    name = name,
                    description = description
                )
                frameDescViewModel.insert(frameDesc)
            }
            with(sheetFragment){
                showToast(getString(R.string.saved_successfully))
                dismiss()
            }

        } else {
            with(sheetFragment){
                dismiss()
                showToast(getString(R.string.fields_cant_be_null))
            }

        }

    }
}