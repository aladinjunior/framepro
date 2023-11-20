package com.aladin.framepro.data.models

import java.io.Serializable


data class FrameDescription(
    var id: Long = 0,
    var registerId: Long = 0,
    var name: String = "",
    var width: Double = 0.0,
    var height: Double = 0.0,
    var description: String = ""
) : Serializable
