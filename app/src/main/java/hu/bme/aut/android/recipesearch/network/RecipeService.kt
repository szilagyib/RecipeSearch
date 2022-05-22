package hu.bme.aut.android.recipesearch.network

import com.skydoves.sandwich.ApiResponse
import hu.bme.aut.android.recipesearch.model.Recipes
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {
    @GET("api/json/v1/1/search.php")
    suspend fun fetchRecipeList(@Query("s") s: String): ApiResponse<Recipes>
}