package com.aladin.framepro.data.db.repositories

import androidx.lifecycle.LiveData
import com.aladin.framepro.data.db.RegisterEntity
import com.aladin.framepro.data.models.Register

interface RegisterRepository {


    val allRegisters : LiveData<List<Register>>
    suspend fun createRegister(register: Register)



}