package com.aladin.framepro.extensions

import android.content.Context
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.aladin.framepro.R
import com.aladin.framepro.domain.model.Frame
import com.aladin.framepro.domain.model.FrameEntity
import com.aladin.framepro.domain.model.FrameView
import com.aladin.framepro.domain.model.FrameViewEntity
import com.aladin.framepro.domain.model.RegisterEntity
import com.aladin.framepro.domain.model.Register
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

fun RegisterEntity.toRegister() : Register {
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

fun FrameView.toFrameViewEntity() : FrameViewEntity {
    return with(this){
        FrameViewEntity(
            imgCover = imgCover,
            name = name,
            material = material
        )
    }
}

fun FrameViewEntity.toFrameView() : FrameView {
    return with(this){
        FrameView(
            imgCover = imgCover,
            name = name,
            material = material
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

fun resourcesToUri(context: Context, resourceId: Int): Uri =
    Uri.parse("android.resource://" + context.packageName + "/" + resourceId)
