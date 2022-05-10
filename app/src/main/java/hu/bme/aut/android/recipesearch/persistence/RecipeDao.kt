package hu.bme.aut.android.recipesearch.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hu.bme.aut.android.recipesearch.model.Recipe
import rx.Observable

@Dao
interface RecipeDao {
    @Query("SELECT * FROM Recipe")
    suspend fun getRecipeList(): List<Recipe>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipeList(recipeList: Observable<List<Recipe>>)
}