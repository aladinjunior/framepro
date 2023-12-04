package com.aladin.framepro.domain.model

import java.io.Serializable


data class Frame(
    var id: Long = 0,
    var registerId: Long = 0,
    var name: String = "",
    var width: Double = 0.0,
    var height: Double = 0.0,
    var description: String = ""
) : Serializable
