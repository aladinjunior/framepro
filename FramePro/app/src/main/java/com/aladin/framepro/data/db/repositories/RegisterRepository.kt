package com.aladin.framepro.data.db.repositories

import com.aladin.framepro.data.models.Register

interface RegisterRepository {

    suspend fun createRegister(register: Register)

}