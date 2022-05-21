package hu.bme.aut.android.recipesearch.model

data class Ingredient(
    val name: String,
    val measurement: String) {

    override fun toString(): String {
        return "$name $measurement"
    }
}