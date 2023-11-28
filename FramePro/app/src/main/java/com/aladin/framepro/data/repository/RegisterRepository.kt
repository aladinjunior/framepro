package com.aladin.framepro.data.repository

import com.aladin.framepro.data.models.Register
import javax.inject.Inject

class RegisterRepository @Inject constructor(
    private val dataSource: RegisterDataSource
) {

    suspend fun createRegister(register: Register) : Long = dataSource.createRegister(register)

    suspend fun deleteRegister(register: Register) = dataSource.deleteRegister(register)

}