package com.example.foodapp.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.foodapp.JsonParser
import com.example.foodapp.entities.Category
import com.google.gson.reflect.TypeToken
//
//@ProvidedTypeConverter
//class Converters(
//    private val jsonParser: JsonParser
//) {
//    @TypeConverter
//    fun toMeaningJson(meaning: List<Meaning>) : String {
//        return jsonParser.toJson(
//            meaning,
//            object : TypeToken<ArrayList<Meaning>>(){}.type
//        ) ?: "[]"
//    }
//
//    @TypeConverter
//    fun fromMeaningsJson(json: String): List<Category>{
//        return jsonParser.fromJson<ArrayList<Category>>(
//            json,
//            object: TypeToken<ArrayList<Category>>(){}.type
//        ) ?: emptyList()
//    }
//}