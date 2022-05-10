package hu.bme.aut.android.recipesearch.ui.details

import hu.bme.aut.android.recipesearch.persistence.RecipeDao
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val recipeDao: RecipeDao
) {
}