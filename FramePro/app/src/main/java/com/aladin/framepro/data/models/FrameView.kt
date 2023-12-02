package com.aladin.framepro.data.models

import android.content.Context
import android.net.Uri
import com.aladin.framepro.R
import com.aladin.framepro.extensions.getResourceUri

data class FrameView(
    val imgCover: Uri,
    val name: String,
    val material: String,

    )

class FrameViewBuilder {

    var imgCover: Uri = Uri.EMPTY
    var name: String = ""
    var material: String = "Alumínio"

    fun build(): FrameView = FrameView(imgCover, name, material)
}

fun frameView(block: FrameViewBuilder.() -> Unit): FrameView =
    FrameViewBuilder().apply(block).build()

fun initialFrames(context: Context) = listOf(
    frameView {
        imgCover = getResourceUri(context, R.drawable.pcorrer_2f)
        name = context.getString(R.string.pcorrer_2f)
    },

    frameView {
        imgCover = getResourceUri(context, R.drawable.pcorrer_2f)
        name = context.getString(R.string.pcorrer_2f)
    }
)
