package com.aladin.framepro.domain.model

import java.io.Serializable


data class Register(
    var id: Long = 0,
    var name: String = "",
    var address: String = "",
    var frames: List<Frame> = listOf()
) : Serializable
