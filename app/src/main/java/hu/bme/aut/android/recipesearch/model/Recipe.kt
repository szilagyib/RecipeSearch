package hu.bme.aut.android.recipesearch.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class Recipe(
    @PrimaryKey val id: Long,
    val name: String,
    val imageUrl: String,
    val instructions: String,
    @Embedded @TypeConverters(Converters::class) val ingredients: List<Ingredient>) {

    companion object {
        fun mock() = Recipe(
            id = 52777,
            name = "Mediterranean Pasta Salad",
            imageUrl = "https://www.themealdb.com/images/media/meals/wvqpwt1468339226.jpg",
            instructions = "Bring a large saucepan of salted water to the boil Add the pasta, " +
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
            ingredients = listOf(
                Ingredient("mozzarella balls", "200 g"),
                Ingredient("baby plum tomatoes", "250 g"),
                Ingredient("fresh basil", "1 bunch"),
                Ingredient("farfalle", "350 g"),
                Ingredient("extra virgin olive oil", "3  tablespoons"),
                Ingredient("Green Olives", "40 g"),
                Ingredient("tuna", "200 g"),
                Ingredient("salt", "to taste"),
                Ingredient("pepper", "to taste")
            )
        )
    }
}

