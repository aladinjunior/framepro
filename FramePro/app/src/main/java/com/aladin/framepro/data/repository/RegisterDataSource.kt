package com.aladin.framepro.data.repository

import androidx.lifecycle.LiveData
import com.aladin.framepro.domain.model.Register

interface RegisterDataSource {


    val allRegisters : LiveData<List<Register>>

    suspend fun createRegister(register: Register) : Long

    suspend fun deleteRegister(register: Register)




}