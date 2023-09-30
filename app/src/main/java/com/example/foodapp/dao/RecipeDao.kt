package com.example.foodapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapp.entities.Category
import com.example.foodapp.entities.CategoryItem

@Dao
interface RecipeDao {
    @get:Query("SELECT *FROM CategoryItem ORDER BY id DESC")
    val getAllCategory: List<CategoryItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category): Long

    @Query("DELETE FROM CategoryItem")
    suspend fun clearedDB()

}