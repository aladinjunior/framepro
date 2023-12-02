package com.aladin.framepro.data.models

import android.content.Context
import android.net.Uri
import com.aladin.framepro.R
import com.aladin.framepro.extensions.resourcesToUri

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

fun initialFrames(context: Context) = mutableListOf(
    frameView {
        imgCover = resourcesToUri(context, R.drawable.pcorrer_2f)
        name = context.getString(R.string.pcorrer_2f)
    },

    frameView {
        imgCover = resourcesToUri(context, R.drawable.pcorrer_3f)
        name = context.getString(R.string.pcorrer_3f)
    },

    frameView {
        imgCover = resourcesToUri(context, R.drawable.pcorrer_4f)
        name = context.getString(R.string.pcorrer_4f)
    },

    frameView {
        imgCover = resourcesToUri(context, R.drawable.pgiro)
        name = context.getString(R.string.pspin)
    },

    frameView {
        imgCover = resourcesToUri(context, R.drawable.jcorrer_2f)
        name = context.getString(R.string.jcorrer_2f)
    },

    frameView {
        imgCover = resourcesToUri(context, R.drawable.jcorrer_3f)
        name = context.getString(R.string.jcorrer_3f)
    },

    frameView {
        imgCover = resourcesToUri(context, R.drawable.jcorrer_4f)
        name = context.getString(R.string.jcorrer_4f)
    },

    frameView {
        imgCover = resourcesToUri(context, R.drawable.pivotante)
        name = context.getString(R.string.pivot)
    },

    frameView {
        imgCover = resourcesToUri(context, R.drawable.maxim_ar)
        name = context.getString(R.string.maxim_ar)
    },

    frameView {
        imgCover = resourcesToUri(context, R.drawable.quadro_fixo)
        name = context.getString(R.string.fixed)
    },

    frameView {
        imgCover = resourcesToUri(context, R.drawable.guarda_corpo)
        name = context.getString(R.string.keep_body)
    },
)
