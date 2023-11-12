package com.aladin.framepro.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class FrameViewModel(application: Application) : AndroidViewModel(application) {


    val height = MutableLiveData<Double>()
    val width = MutableLiveData<Double>()
    val description = MutableLiveData<String>()

}