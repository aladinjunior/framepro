package com.aladin.framepro.extensions

import androidx.room.TypeConverter
import com.aladin.framepro.data.models.Frame
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromString(value: String?): List<Frame> {
        if (value == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<Frame>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Frame>): String {
        return gson.toJson(list)
    }
}


