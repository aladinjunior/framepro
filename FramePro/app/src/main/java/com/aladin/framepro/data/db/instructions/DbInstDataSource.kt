package com.aladin.framepro.data.db.instructions


import com.aladin.framepro.data.models.FrameDescription
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.viewmodels.FrameDescriptionViewModel
import com.aladin.framepro.viewmodels.RegisterViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DbInstDataSource(
    private val dbInstructionsImpl: DbInstructionsImpl
) : DbInstBase {

     override fun saveOnRegisterDb(sheetFragment: BottomSheetDialogFragment, registerViewModel: RegisterViewModel, name: String, address: String, frames: List<FrameDescription>) : Register {
         return dbInstructionsImpl.saveOnRegisterDb(sheetFragment, registerViewModel, name, address, frames)
    }

     override fun saveOnFrameDb(sheetFragment: BottomSheetDialogFragment, frameDescViewModel: FrameDescriptionViewModel, name: String, registerId: Long,  width: Double, height: Double, description: String) {
         dbInstructionsImpl.saveOnFrameDb(sheetFragment, frameDescViewModel, name, registerId, width, height, description)
     }
}