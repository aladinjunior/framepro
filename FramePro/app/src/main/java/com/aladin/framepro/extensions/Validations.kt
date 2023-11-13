package com.aladin.framepro.extensions

class Validations {

    fun isNotEmptyData(name: String, address: String): Boolean {
        return name.isNotEmpty() && name.isNotBlank() && address.isNotEmpty() && address.isNotBlank()
    }

    fun isNotEmptyData(width: Double, height: Double, description: String): Boolean {
        return width.toString().isNotEmpty() && height.toString()
            .isNotBlank() && description.isNotEmpty()
    }
}