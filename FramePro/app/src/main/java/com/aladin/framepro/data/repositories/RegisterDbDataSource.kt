package com.aladin.framepro.data.repositories

import androidx.lifecycle.LiveData
import com.aladin.framepro.data.db.daos.RegisterDao
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.extensions.map
import com.aladin.framepro.extensions.toRegister
import com.aladin.framepro.extensions.toRegisterEntity

class RegisterDbDataSource(
    private val registerDao: RegisterDao
) : RegisterRepository {

    override val allRegisters: LiveData<List<Register>> =
        registerDao.getAllRegisters().map { listOfRegisterEntity ->
            listOfRegisterEntity.map { registerEntity ->
                registerEntity.toRegister()
            }
        }

    override suspend fun createRegister(register: Register) : Long {
        val registerEntity = register.toRegisterEntity()
        return registerDao.register(registerEntity)
    }

    override suspend fun deleteRegister(register: Register) {
        val registerEntity = register.toRegisterEntity()
        registerDao.delete(registerEntity)

    }


}