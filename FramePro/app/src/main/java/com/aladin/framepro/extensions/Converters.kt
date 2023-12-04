package com.aladin.framepro.extensions

import android.net.Uri
import androidx.room.TypeConverter
import com.aladin.framepro.domain.model.Frame
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

    @TypeConverter
    fun uriFromString(value: String?) : Uri? {
       return value?.let { Uri.parse(it) }
    }

    @TypeConverter
    fun uriToString(uri: Uri?) : String? {
        return uri?.toString()
    }
}


