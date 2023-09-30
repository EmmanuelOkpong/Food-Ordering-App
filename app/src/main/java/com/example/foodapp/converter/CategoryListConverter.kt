package com.example.foodapp.converter

import androidx.room.TypeConverter
import com.example.foodapp.entities.Category
import com.example.foodapp.entities.CategoryItems
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoryListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<Category>): String? {
        if (category == null) {
            return (null)
        } else {
            val gson = Gson()
            val type = object : TypeToken<Category>() {

            }.type
            return gson.toJson(category, type)
        }
    }

    @TypeConverter
    fun toCategoryList(categoryString: String): List<Category>? {
        if (categoryString == null) {
            return (null)
        } else {

            val gson = Gson()
            val type = object : TypeToken<Category>() {

            }.type
            return gson.fromJson(categoryString, type)

        }
    }
}
//
//
//    @TypeConverter
//    fun listToJson(value: List<CategoryItems>) = Gson().toJson(value)
//
//    @TypeConverter
//    fun jsonToList(value: String) =
//        Gson().fromJson(value, Array<CategoryItems>::class.java).toList()
//}