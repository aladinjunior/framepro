package com.aladin.framepro.viewmodel

import android.app.Application
import android.text.Editable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aladin.framepro.data.models.Frame
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddFrameViewModel @Inject constructor(
    application: Application,
) : AndroidViewModel(application) {


    private val listOfFrames = mutableListOf<Frame>()

    private val _listOfFramesLiveData = MutableLiveData<List<Frame>>()

    val listOfFramesLiveData: LiveData<List<Frame>> get() = _listOfFramesLiveData

    private val _savedOnDb = MutableLiveData<Boolean>()

    val savedOnDb: LiveData<Boolean> get() = _savedOnDb


    fun buildFrame(name: String, width: Double, height: Double, description: String) : Frame =
        Frame(
            name = name,
            width = width,
            height = height,
            description = description
        )

    fun emptyFieldError(width: Editable?, height: Editable?, description: Editable?) : Boolean =
         width?.isNotEmpty() == true && height?.isNotEmpty() == true && description?.isNotEmpty() == true


    fun addFrameToList(frame: Frame) = viewModelScope.launch {
        listOfFrames.add(frame)
        _listOfFramesLiveData.postValue(listOfFrames)
    }

    fun saved(boolean: Boolean) : Boolean{
        _savedOnDb.postValue(boolean)
        return boolean
    }

}