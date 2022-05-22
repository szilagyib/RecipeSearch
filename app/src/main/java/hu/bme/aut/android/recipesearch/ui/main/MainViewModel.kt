package hu.bme.aut.android.recipesearch.ui.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.android.recipesearch.model.Recipe
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    mainRepository: MainRepository
) : ViewModel() {

    var recipeName: String = "salad"

    val recipeList: Flow<List<Recipe>> =
        mainRepository.loadRecipes(
            recipeName,
            onStart = { println("started") },
            onCompletion = { println("completed") },
            onError = { message -> println(message) }
        )
}