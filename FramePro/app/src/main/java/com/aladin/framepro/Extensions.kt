package com.aladin.framepro

import android.view.View
import androidx.core.content.ContextCompat
import com.aladin.framepro.ui.NewRegisterSheet
import com.google.android.material.bottomsheet.BottomSheetDialog

fun NewRegisterSheet.setSheetBackground(){

    dialog?.setOnShowListener {
        val dialog = it as? BottomSheetDialog
        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheet?.background = ContextCompat.getDrawable(requireContext(), R.drawable.background_no_rounded_corners)
    }
}