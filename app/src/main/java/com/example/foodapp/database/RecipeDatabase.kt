package com.example.foodapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foodapp.database.converter.CategoryListConverter
import com.example.foodapp.model.Category
import com.example.foodapp.model.Recipes

@Database(entities = [Recipes::class, Category::class], version = 1, exportSchema = false)
@TypeConverters(CategoryListConverter::class)
abstract class RecipeDatabase : RoomDatabase() {

    companion object {

        private var recipesDatabase: RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase {
            if (recipesDatabase == null) {
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }
    }

    abstract fun recipeDao(): RecipeDao
}