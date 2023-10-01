package com.example.foodapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Entity(tableName = "CategoryItem")
data class CategoryItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "idcategory") @Expose @SerializedName("idCategory") val categoryId: String = "",
    @ColumnInfo(name = "strcategory") @Expose @SerializedName("strCategory") val strcategory: String = "",
    @ColumnInfo(name = "strcategorythumb") @Expose @SerializedName("strCategoryThumb") val strcategorythumb: String = "",
    @ColumnInfo(name = "strcategorydescription") @Expose @SerializedName("strCategoryDescription") val strcategorydescription: String = ""
) {
    constructor() : this(0) // No-argument constructor for Room
}
