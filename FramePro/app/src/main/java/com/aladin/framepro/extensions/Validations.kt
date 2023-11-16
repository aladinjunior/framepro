package com.aladin.framepro.extensions

class Validations {

    fun isNotEmptyData(name: String, address: String): Boolean {
        return name.isNotEmpty() && name.isNotBlank() && address.isNotEmpty() && address.isNotBlank()
    }

    fun isNotEmptyFrameData(width: Double, height: Double, description: String): Boolean {
        return width.toString().isNotEmpty() && width.toString().isNotBlank() && height.toString()
            .isNotBlank() && height.toString().isNotEmpty() &&
        description.isNotBlank() && description.isNotEmpty()
    }
}