package com.aladin.framepro.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.aladin.framepro.data.repository.RegisterDataSource
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.domain.register.usecase.CreateRegisterUseCase
import com.aladin.framepro.domain.register.usecase.DeleteRegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    application: Application,
    dataSource: RegisterDataSource,
    private val createRegisterUseCase: CreateRegisterUseCase,
    private val deleteRegisterUseCase: DeleteRegisterUseCase,
) : AndroidViewModel(application) {


    fun emptyFieldError(firstField: String, secondField: String) : Boolean =
        firstField.isEmpty() or firstField.isBlank() or secondField.isEmpty() or secondField.isBlank()


    val allRegisters: LiveData<List<Register>> = dataSource.allRegisters

    fun createRegister(register: Register) = viewModelScope.launch {
        createRegisterUseCase(register)
    }

    fun deleteRegister(register: Register) = viewModelScope.launch {
        deleteRegisterUseCase(register)
    }





}