package hu.bme.aut.android.recipesearch.ui.details

import androidx.annotation.WorkerThread
import hu.bme.aut.android.recipesearch.persistence.RecipeDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val recipeDao: RecipeDao
) {
    @WorkerThread
    fun getRecipeById(id: Long) = flow {
        val recipe = recipeDao.getRecipe(id)
        emit(recipe)
    }.flowOn(Dispatchers.IO)
}