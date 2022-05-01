package hu.bme.aut.android.recipesearch.ui.main

import hu.bme.aut.android.recipesearch.network.RecipeService
import hu.bme.aut.android.recipesearch.persistence.RecipeDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val recipeService: RecipeService,
    private val recipeDao: RecipeDao
) {
}