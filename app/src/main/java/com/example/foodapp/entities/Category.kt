package com.example.foodapp.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Category")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @Expose @SerializedName("categories") var categoryItems: List<CategoryItem>? = null
) {
    constructor() : this(0, null) // No-argument constructor for Room
}

