package com.aladin.framepro.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RegisterEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    val name: String,
    val address: String
)