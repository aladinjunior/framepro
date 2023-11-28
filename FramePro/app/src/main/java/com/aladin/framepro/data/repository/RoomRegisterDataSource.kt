package com.aladin.framepro.data.repository

import androidx.lifecycle.LiveData
import com.aladin.framepro.data.db.daos.RegisterDao
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.extensions.map
import com.aladin.framepro.extensions.toRegister
import com.aladin.framepro.extensions.toRegisterEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RoomRegisterDataSource
    @Inject constructor(
    private val registerDao: RegisterDao
) : RegisterDataSource {

    override val allRegisters: LiveData<List<Register>> =
        registerDao.getAllRegisters().map { listOfRegisterEntity ->
            listOfRegisterEntity.map { registerEntity ->
                registerEntity.toRegister()
            }
        }

    override suspend fun createRegister(register: Register) : Long {
        return withContext(Dispatchers.IO) {
            val registerEntity = register.toRegisterEntity()
            registerDao.register(registerEntity)
        }

    }

    override suspend fun deleteRegister(register: Register) {
        return withContext(Dispatchers.IO){
            val registerEntity = register.toRegisterEntity()
            registerDao.delete(registerEntity)
        }

    }


}