package hu.bme.aut.android.recipesearch.network

import hu.bme.aut.android.recipesearch.model.Recipe
import retrofit2.http.GET
import rx.Observable

interface RecipeService {
    @GET("/search")
    suspend fun fetchRecipeList(): Observable<List<Recipe>>
}