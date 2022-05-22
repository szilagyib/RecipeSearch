package hu.bme.aut.android.recipesearch.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class Recipe(
    @PrimaryKey val idMeal: Long,
    val strMeal: String = "",
    val strDrinkAlternate: String? = "",
    val strCategory: String? = "",
    val strArea: String? = "",
    val strInstructions: String? = "",
    val strMealThumb: String? = "",
    val strTags: String? = "",
    val strYoutube: String? = "",
    val strIngredient1: String? = "",
    val strIngredient2: String? = "",
    val strIngredient3: String? = "",
    val strIngredient4: String? = "",
    val strIngredient5: String? = "",
    val strIngredient6: String? = "",
    val strIngredient7: String? = "",
    val strIngredient8: String? = "",
    val strIngredient9: String? = "",
    val strIngredient10: String? = "",
    val strIngredient11: String? = "",
    val strIngredient12: String? = "",
    val strIngredient13: String? = "",
    val strIngredient14: String? = "",
    val strIngredient15: String? = "",
    val strIngredient16: String? = "",
    val strIngredient17: String? = "",
    val strIngredient18: String? = "",
    val strIngredient19: String? = "",
    val strIngredient20: String? = "",
    val strMeasure1: String? = "",
    val strMeasure2: String? = "",
    val strMeasure3: String? = "",
    val strMeasure4: String? = "",
    val strMeasure5: String? = "",
    val strMeasure6: String? = "",
    val strMeasure7: String? = "",
    val strMeasure8: String? = "",
    val strMeasure9: String? = "",
    val strMeasure10: String? = "",
    val strMeasure11: String? = "",
    val strMeasure12: String? = "",
    val strMeasure13: String? = "",
    val strMeasure14: String? = "",
    val strMeasure15: String? = "",
    val strMeasure16: String? = "",
    val strMeasure17: String? = "",
    val strMeasure18: String? = "",
    val strMeasure19: String? = "",
    val strMeasure20: String? = "",
    val strSource: String? = "",
    val strImageSource: String? = "",
    val strCreativeCommonsConfirmed: String? = "",
    val dateModified: String? = "",
) {

    @Ignore
    var ingredients: MutableList<Ingredient> = mutableListOf()

    init {
        addIngredient(strIngredient1, strMeasure1)
        addIngredient(strIngredient2, strMeasure2)
        addIngredient(strIngredient3, strMeasure3)
        addIngredient(strIngredient4, strMeasure4)
        addIngredient(strIngredient5, strMeasure5)
        addIngredient(strIngredient6, strMeasure6)
        addIngredient(strIngredient7, strMeasure7)
        addIngredient(strIngredient8, strMeasure8)
        addIngredient(strIngredient9, strMeasure9)
        addIngredient(strIngredient10, strMeasure10)
        addIngredient(strIngredient11, strMeasure11)
        addIngredient(strIngredient12, strMeasure12)
        addIngredient(strIngredient13, strMeasure13)
        addIngredient(strIngredient14, strMeasure14)
        addIngredient(strIngredient15, strMeasure15)
        addIngredient(strIngredient16, strMeasure16)
        addIngredient(strIngredient17, strMeasure17)
        addIngredient(strIngredient18, strMeasure18)
        addIngredient(strIngredient19, strMeasure19)
        addIngredient(strIngredient20, strMeasure20)
    }

    companion object {
        fun mock() = Recipe(
            idMeal = 52777,
            strMeal = "Mediterranean Pasta Salad",
            strImageSource = "https://www.themealdb.com/images/media/meals/wvqpwt1468339226.jpg",
            strInstructions = "Bring a large saucepan of salted water to the boil Add the pasta, " +
                    "stir once and cook for about 10 minutes or as directed on the packet.\n" +
                    "Meanwhile, wash the tomatoes and cut into quarters.\n" +
                    "Slice the olives.\n" +
                    "Wash the basil.\n" +
                    "Put the tomatoes into a salad bowl and tear the basil leaves over them.\n" +
                    "Add a tablespoon of olive oil and mix.\n" +
                    "When the pasta is ready, drain into a colander and run cold water over it " +
                    "to cool it quickly.\n" +
                    "Toss the pasta into the salad bowl with the tomatoes and basil.\n" +
                    "Add the sliced olives, drained mozzarella balls, and chunks of tuna.\n" +
                    "Mix well and let the salad rest for at least half an hour to allow the " +
                    "flavours to mingle.\n" +
                    "Sprinkle the pasta with a generous grind of black pepper and drizzle with " +
                    "the remaining olive oil just before serving.",
            strIngredient1 = "mozzarella balls",
            strMeasure1 = "200 g",
            strIngredient2 = "baby plum tomatoes",
            strMeasure2 = "250 g",
            strIngredient3 = "fresh basil",
            strMeasure3 = "1 bunch",
            strIngredient4 = "farfalle",
            strMeasure4 = "350 g",
            strIngredient5 = "extra virgin olive oil",
            strMeasure5 = "3  tablespoons",
            strIngredient6 = "Green Olives",
            strMeasure6 = "40 g",
            strIngredient7 = "tuna",
            strMeasure7 = "200 g",
            strIngredient8 = "salt",
            strMeasure8 = "to taste",
            strIngredient9 = "pepper",
            strMeasure9 = "to taste"
        )
    }

    private fun addIngredient(ingredient: String?, measure: String?) {
        ingredient?.let {
            if(ingredient != "")
                ingredients.add(Ingredient(ingredient, measure ?: ""))
        }
    }
}
