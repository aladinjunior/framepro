package com.aladin.framepro.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aladin.framepro.data.db.AppDatabase
import com.aladin.framepro.data.repositories.RegisterDbDataSource
import com.aladin.framepro.data.repositories.RegisterRepository
import com.aladin.framepro.data.models.Register
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class RegisterViewModel(
    application: Application
) : AndroidViewModel(application) {

    val name = MutableLiveData<String>()
    val address = MutableLiveData<String>()
    val id = MutableLiveData<Long>()




    private val registerRepository: RegisterRepository
    val allRegisters: LiveData<List<Register>>


    init {
        val dao = AppDatabase.getDatabase(application).registerDao()
        registerRepository = RegisterDbDataSource(dao)
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



}