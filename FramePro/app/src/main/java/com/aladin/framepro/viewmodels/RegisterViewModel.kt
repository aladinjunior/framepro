package com.aladin.framepro.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    val name = MutableLiveData<String>()
    val address = MutableLiveData<String>()

    fun register(inputtedName: String, inputtedAddress: String) {

        name.postValue(inputtedName)
        address.postValue(inputtedAddress)

    }


}