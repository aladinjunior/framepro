package com.aladin.framepro.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.aladin.framepro.data.db.AppDatabase
import com.aladin.framepro.data.db.repositories.RegisterDbDataSource
import com.aladin.framepro.data.db.repositories.RegisterRepository
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.data.models.RegisterViewParams
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RegisterViewModel(
    application: Application
) : AndroidViewModel(application) {

    val name = MutableLiveData<String>()
    val address = MutableLiveData<String>()


    private val registerRepository: RegisterRepository

    init {
        val dao = AppDatabase.getDatabase(application).registerDao()
         registerRepository = RegisterDbDataSource(dao)
    }


    fun register(register: Register): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            registerRepository.createRegister(register)
        }

    }

    class RegisterViewModelFactory(

        private val application: Application
    ) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RegisterViewModel(application) as T
        }
    }


}