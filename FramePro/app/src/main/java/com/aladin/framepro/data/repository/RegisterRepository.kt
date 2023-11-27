package com.aladin.framepro.data.repository

import androidx.lifecycle.LiveData
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.data.repositories.RegisterDataSource

class RegisterRepository(private val dataSource: RegisterDataSource) {

    suspend fun createRegister(register: Register) : Long = dataSource.createRegister(register)

    suspend fun getRegisters() : LiveData<List<Register>> = dataSource.allRegisters

    suspend fun deleteRegister(register: Register) = dataSource.deleteRegister(register)

}