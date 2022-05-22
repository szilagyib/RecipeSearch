package hu.bme.aut.android.recipesearch.ui.main

import androidx.annotation.WorkerThread
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.suspendOnSuccess
import hu.bme.aut.android.recipesearch.model.Recipe
import hu.bme.aut.android.recipesearch.network.RecipeService
import hu.bme.aut.android.recipesearch.persistence.RecipeDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val recipeService: RecipeService,
    private val recipeDao: RecipeDao
) {

    @WorkerThread
    fun loadRecipes(
        s: String,
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val recipes: List<Recipe> = recipeDao.getRecipeList()
        if (recipes.isEmpty()) {
            recipeService.fetchRecipeList(s)
                .suspendOnSuccess {
                    recipeDao.insertRecipeList(data.meals)
                    emit(data.meals)
                }
                .onFailure { onError(this) }
        } else {
            emit(recipes)
        }
    }
    .onStart { onStart() }
    .onCompletion { onCompletion() }
    .flowOn(Dispatchers.IO)
}