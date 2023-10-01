package com.example.foodapp.converter

import androidx.room.TypeConverter
import com.example.foodapp.entities.Category
import com.example.foodapp.entities.CategoryItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoryListConverter {
    @TypeConverter
    fun fromCatItems(items: List<CategoryItem>?): String? {
        if (items == null) {
            return null
        }

        val gson = Gson()
        val type = object : TypeToken<CategoryItem>() {}.type

        return gson.toJson(items, type)
    }

    @TypeConverter
    fun toCatItems(categoryString: String?): List<CategoryItem>? {
        if (categoryString == null) {
            return (null)
        }
        val gson = Gson()
        val type = object : TypeToken<Category>() {}.type
        return gson.fromJson(categoryString, type)
    }

}
