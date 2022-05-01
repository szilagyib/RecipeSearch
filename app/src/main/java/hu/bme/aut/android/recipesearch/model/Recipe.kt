package hu.bme.aut.android.recipesearch.model

data class Recipe(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val instructions: String,
    val ingredients: List<Ingredient>)
