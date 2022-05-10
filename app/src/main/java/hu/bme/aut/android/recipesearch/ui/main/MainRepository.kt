package hu.bme.aut.android.recipesearch.ui.main

import hu.bme.aut.android.recipesearch.model.Recipe
import hu.bme.aut.android.recipesearch.network.RecipeService
import hu.bme.aut.android.recipesearch.persistence.RecipeDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val recipeService: RecipeService,
    private val recipeDao: RecipeDao
) {
    suspend fun loadRecipes() {
        val recipeList: List<Recipe> = recipeDao.getRecipeList()
        if (recipeList.isEmpty())
            recipeDao.insertRecipeList(recipeService.fetchRecipeList())
    }
}