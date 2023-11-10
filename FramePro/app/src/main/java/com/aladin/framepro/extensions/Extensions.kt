package com.aladin.framepro.extensions

import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.aladin.framepro.R
import com.aladin.framepro.data.db.RegisterEntity
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.ui.NewRegisterSheet
import com.google.android.material.bottomsheet.BottomSheetDialog

fun NewRegisterSheet.setSheetBackground(){

    dialog?.setOnShowListener {
        val dialog = it as? BottomSheetDialog
        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheet?.background = ContextCompat.getDrawable(requireContext(),
            R.drawable.background_no_rounded_corners
        )
    }
}


fun Register.toRegisterEntity() : RegisterEntity{
    return with(this){
        RegisterEntity(
            name = name,
            address = address
        )
    }
}

fun RegisterEntity.toRegister() : Register{
    return with(this){
        Register(
            id = id,
            name = name,
            address = address
        )
    }
}

fun <T, U> LiveData<T>.map(transform: (T) -> U): LiveData<U> {
    val result = MediatorLiveData<U>()
    result.addSource(this) { data ->
        result.value = transform(data)
    }
    return result
}