package hu.bme.aut.android.recipesearch.persistence

import androidx.room.RoomDatabase

abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}