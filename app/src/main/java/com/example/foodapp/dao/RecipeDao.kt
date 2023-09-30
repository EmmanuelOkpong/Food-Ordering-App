package com.example.foodapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapp.entities.Category
import com.example.foodapp.entities.CategoryItems
import com.example.foodapp.entities.Recipes

@Dao
interface RecipeDao {
    @get:Query("SELECT *FROM categoryitems ORDER BY id DESC")
    val getAllCategory:List<CategoryItems>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryItems: CategoryItems)

    @Query("DELETE FROM categoryitems")
    suspend fun clearedDB()

}