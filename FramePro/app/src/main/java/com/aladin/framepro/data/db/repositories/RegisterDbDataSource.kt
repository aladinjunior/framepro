package com.aladin.framepro.data.db.repositories

import com.aladin.framepro.data.db.daos.RegisterDao
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.extensions.toRegisterEntity

class RegisterDbDataSource(
    private val registerDao: RegisterDao
) : RegisterRepository {

    override suspend fun createRegister(register: Register) {
        val registerEntity = register.toRegisterEntity()
        registerDao.insert(registerEntity)
    }


}