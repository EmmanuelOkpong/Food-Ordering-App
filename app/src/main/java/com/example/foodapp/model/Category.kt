package com.example.foodapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull


@Parcelize
@Entity(tableName = "Category")
data class Category(
   @PrimaryKey @ColumnInfo(name = "id") @Expose @SerializedName("idCategory") val id: String,
    @ColumnInfo(name = "categoryName") @Expose @SerializedName("strCategory") val categoryName: String? = null,
    @ColumnInfo(name = "categoryDescription") @Expose @SerializedName("strCategoryDescription") val categoryDescription: String? = null,
    @ColumnInfo(name = "imgUrl") @Expose @SerializedName("strCategoryThumb") val imgUrl: String? = null
) : Parcelable