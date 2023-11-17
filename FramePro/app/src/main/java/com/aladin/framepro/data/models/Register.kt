package com.aladin.framepro.data.models

import java.io.Serializable


data class Register(
    var id: Long = 0,
    var name: String = "",
    var address: String = "",
    var frames: List<FrameDescription> = listOf()
) : Serializable
