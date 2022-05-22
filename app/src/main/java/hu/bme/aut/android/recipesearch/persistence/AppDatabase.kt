package hu.bme.aut.android.recipesearch.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.bme.aut.android.recipesearch.model.Recipe

@Database(entities = [Recipe::class], version = 2, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}