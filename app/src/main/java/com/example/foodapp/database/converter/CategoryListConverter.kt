package com.example.foodapp.database.converter

import androidx.room.TypeConverter
import com.example.foodapp.model.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoryListConverter {
    @TypeConverter
    fun fromCatItems(items: List<Category>?): String? {
        if (items == null) {
            return null
        }

        val gson = Gson()
        val type = object : TypeToken<Category>() {}.type

        return gson.toJson(items, type)
    }

    @TypeConverter
    fun toCatItems(categoryString: String?): List<Category>? {
        if (categoryString == null) {
            return (null)
        }
        val gson = Gson()
        val type = object : TypeToken<Category>() {}.type
        return gson.fromJson(categoryString, type)
    }

}
