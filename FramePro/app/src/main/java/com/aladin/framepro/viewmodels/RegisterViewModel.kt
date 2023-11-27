package com.aladin.framepro.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aladin.framepro.data.db.AppDatabase
import com.aladin.framepro.data.repositories.RoomRegisterDataSource
import com.aladin.framepro.data.repositories.RegisterDataSource
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.domain.register.usecase.CreateRegisterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class RegisterViewModel(
    application: Application,
    private val createRegisterUseCase: CreateRegisterUseCase
) : AndroidViewModel(application) {

    val name = MutableLiveData<String>()
    val address = MutableLiveData<String>()
    val id = MutableLiveData<Long>()



    private val registerRepository: RegisterDataSource
    val allRegisters: LiveData<List<Register>>


    init {
        val dao = AppDatabase.getDatabase(application).registerDao()
        registerRepository = RoomRegisterDataSource(dao)
        allRegisters = registerRepository.allRegisters
    }



    private val _registerId = MutableLiveData<Long>()
    val registerId: LiveData<Long> get() = _registerId


    fun register(register: Register) : Job {
        return viewModelScope.launch(Dispatchers.IO) {
            val id = registerRepository.createRegister(register)
            _registerId.postValue(id)
        }
    }

    fun delete(register: Register) : Job {
        return viewModelScope.launch(Dispatchers.IO) {
            registerRepository.deleteRegister(register)
        }
    }

    fun createRegister(register: Register) = viewModelScope.launch {
        createRegisterUseCase(register)
    }



}