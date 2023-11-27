package com.aladin.framepro.data.repositories

import androidx.lifecycle.LiveData
import com.aladin.framepro.data.models.Register

interface RegisterDataSource {


    val allRegisters : LiveData<List<Register>>

    suspend fun createRegister(register: Register) : Long

    suspend fun deleteRegister(register: Register)




}