package com.aladin.framepro.extensions

import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.aladin.framepro.R
import com.aladin.framepro.adapters.FramesAdapter
import com.aladin.framepro.data.models.FrameView
import com.aladin.framepro.data.models.Frame
import com.aladin.framepro.data.models.FrameEntity
import com.aladin.framepro.data.models.RegisterEntity
import com.aladin.framepro.data.models.Register
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
            address = address,
            frames = frames
        )
    }
}

fun RegisterEntity.toRegister() : Register{
    return with(this){
        Register(
            id = id,
            name = name,
            address = address,
            frames = frames
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

fun Fragment.buildFrames() : List<FrameView> {
    return listOf(
            FrameView(R.drawable.pcorrer_2f, getString(R.string.pcorrer_2f)),
            FrameView(R.drawable.pcorrer_3f, getString(R.string.pcorrer_3f)),
            FrameView(R.drawable.pcorrer_4f, getString(R.string.pcorrer_4f)),
            FrameView(R.drawable.pgiro, getString(R.string.pspin)),
            FrameView(R.drawable.jcorrer_2f, getString(R.string.jcorrer_2f)),
            FrameView(R.drawable.jcorrer_3f, getString(R.string.jcorrer_3f)),
            FrameView(R.drawable.jcorrer_4f, getString(R.string.jcorrer_4f)),
            FrameView(R.drawable.pivotante, getString(R.string.pivot)),
            FrameView(R.drawable.maxim_ar, getString(R.string.maxim_ar)),
            FrameView(R.drawable.quadro_fixo, getString(R.string.fixed)),
            FrameView(R.drawable.guarda_corpo, getString(R.string.keep_body))
        )

}

fun FramesAdapter.FramesViewHolder.setShadowLayer(frameView: FrameView, frameCover: ImageView){

    val imgDrawable = ContextCompat.getDrawable(itemView.context, frameView.imgCover)
    val layerDrawable = ContextCompat.getDrawable(itemView.context, R.drawable.img_background_shadows) as LayerDrawable
    layerDrawable.setDrawableByLayerId(R.id.covered_movie_background, imgDrawable)

    frameCover.setImageDrawable(layerDrawable)
}

fun Frame.toFrameDescriptionEntity() : FrameEntity {
    return with(this){
        FrameEntity(
            registerId = registerId,
            name = name,
            width = width,
            height = height,
            description = description
        )
    }
}

fun FrameEntity.toFrameDescription() : Frame {
    return with(this){
        Frame(
            registerId = registerId,
            name = name,
            width = width,
            height = height,
            description = description
        )
    }
}

fun List<FrameEntity>.toFrameDescription() : List<Frame> {
    return with(this){
       map {
           it.toFrameDescription()
       }

    }
}


fun Fragment.showToast(message: String){
    Toast.makeText(
        requireContext(),
        message,
        Toast.LENGTH_SHORT
    ).show()
}

fun View.oval(@ColorInt color: Int) : ShapeDrawable {
    val oval = ShapeDrawable(OvalShape())
    with(oval){
        intrinsicHeight = height
        intrinsicWidth = width
        paint.color = color
    }

    return oval
}