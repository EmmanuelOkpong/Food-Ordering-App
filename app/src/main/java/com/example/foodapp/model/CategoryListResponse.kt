package com.example.foodapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize



@Parcelize
@Entity(tableName = "Categories")
data class CategoryListResponse(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @Expose @SerializedName("categories") val categories: List<Category?>? = null
) : Parcelable
