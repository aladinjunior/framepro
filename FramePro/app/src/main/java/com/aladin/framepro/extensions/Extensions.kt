package com.aladin.framepro.extensions

import android.graphics.drawable.LayerDrawable
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.aladin.framepro.R
import com.aladin.framepro.adapters.FramesAdapter
import com.aladin.framepro.data.models.Frame
import com.aladin.framepro.data.models.FrameDescription
import com.aladin.framepro.data.models.FrameDescriptionEntity
import com.aladin.framepro.data.models.RegisterEntity
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.ui.NewRegisterSheet
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

fun BottomSheetDialogFragment.setSheetBackground(){

    dialog?.setOnShowListener {
        val dialog = it as? BottomSheetDialog
        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheet?.background = ContextCompat.getDrawable(requireContext(),
            R.drawable.background_no_rounded_corners
        )
    }
}


fun Register.toRegisterEntity() : RegisterEntity {
    return with(this){
        RegisterEntity(
            id = id,
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

fun Fragment.buildFrames() : List<Frame> {
    return listOf(
            Frame(R.drawable.pcorrer_2f, getString(R.string.pcorrer_2f)),
            Frame(R.drawable.pcorrer_3f, getString(R.string.pcorrer_3f)),
            Frame(R.drawable.pcorrer_4f, getString(R.string.pcorrer_4f)),
            Frame(R.drawable.pgiro, getString(R.string.pspin)),
            Frame(R.drawable.jcorrer_2f, getString(R.string.jcorrer_2f)),
            Frame(R.drawable.jcorrer_3f, getString(R.string.jcorrer_3f)),
            Frame(R.drawable.jcorrer_4f, getString(R.string.jcorrer_4f)),
            Frame(R.drawable.pivotante, getString(R.string.pivot)),
            Frame(R.drawable.maxim_ar, getString(R.string.maxim_ar)),
            Frame(R.drawable.quadro_fixo, getString(R.string.fixed)),
            Frame(R.drawable.guarda_corpo, getString(R.string.keep_body))
        )

}

fun FramesAdapter.FramesViewHolder.setShadowLayer(frame: Frame, frameCover: ImageView){

    val imgDrawable = ContextCompat.getDrawable(itemView.context, frame.imgCover)
    val layerDrawable = ContextCompat.getDrawable(itemView.context, R.drawable.img_background_shadows) as LayerDrawable
    layerDrawable.setDrawableByLayerId(R.id.covered_movie_background, imgDrawable)

    frameCover.setImageDrawable(layerDrawable)
}

fun FrameDescription.toFrameDescriptionEntity() : FrameDescriptionEntity {
    return with(this){
        FrameDescriptionEntity(
            registerId = registerId,
            name = name,
            width = width,
            height = height,
            description = description
        )
    }
}