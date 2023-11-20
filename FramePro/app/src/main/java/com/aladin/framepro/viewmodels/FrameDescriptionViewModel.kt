package com.aladin.framepro.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.aladin.framepro.data.db.AppDatabase
import com.aladin.framepro.data.models.FrameDescription
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.data.repositories.FrameDescriptionDbDataSource
import com.aladin.framepro.data.repositories.FrameDescriptionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FrameDescriptionViewModel(
    application: Application
) : AndroidViewModel(application) {


    val height = MutableLiveData<Double>()
    val width = MutableLiveData<Double>()
    val description = MutableLiveData<String>()

    private val frameDescRepository: FrameDescriptionRepository

    private val frameDescriptionList = mutableListOf<FrameDescription>()

    private val _listOfFrames = MutableLiveData<List<FrameDescription>>()
    val listOfFrames: LiveData<List<FrameDescription>> get() = _listOfFrames

    private val _savedOnDb = MutableLiveData<Boolean>()

    val savedOnDb: LiveData<Boolean> get() = _savedOnDb


    init {
        val dao = AppDatabase.getDatabase(application).frameDescriptionDao()
        frameDescRepository = FrameDescriptionDbDataSource(dao)
    }

    fun insert(frameDescription: FrameDescription) : Job {
        return viewModelScope.launch(Dispatchers.IO) {
            frameDescRepository.insertFrameDescription(frameDescription)

        }
    }

    fun addFrameDescToList(frameDescription: FrameDescription){
        frameDescriptionList.add(frameDescription)
        _listOfFrames.postValue(frameDescriptionList)
    }

    fun clearFrameDescList(){
        frameDescriptionList.clear()
        _listOfFrames.postValue(frameDescriptionList)
    }

    fun getFrameDescription(register : Register) : Job {
        return viewModelScope.launch(Dispatchers.IO) {
            val list = frameDescRepository.getFramesOfRegister(register)
            _listOfFrames.postValue(list)
        }
    }

    fun saved(boolean: Boolean) : Boolean{
        _savedOnDb.postValue(boolean)
        return boolean
    }

}