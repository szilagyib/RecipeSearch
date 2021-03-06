package hu.bme.aut.android.recipesearch.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import hu.bme.aut.android.recipesearch.R
import hu.bme.aut.android.recipesearch.model.Recipe

@Composable
fun RecipeDetails(
    id: Long,
    viewModel: DetailsViewModel
) {
    LaunchedEffect(id) {
        viewModel.loadRecipeById(id)
    }

    val details: Recipe? by viewModel.recipeDetailsFlow.collectAsState(initial = null)
    details?.let { recipe ->
        RecipeDetailsBody(recipe)
    }
}

@Composable
fun RecipeDetailsBody(recipe: Recipe) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(4.dp),
                text = recipe.strMeal,
                fontSize = 28.sp
            )
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .height(120.dp),
                model = recipe.strMealThumb,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "user icon"
            )
            for (ingredient in recipe.ingredients) {
                Text(
                    modifier = Modifier
                        .padding(24.dp, 2.dp),
                    text = "??? $ingredient",
                    fontSize = 16.sp
                )
            }
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(weight = 1f, fill = false)
                    .background(colorResource(id = R.color.custom_lightgreen))
                    .padding(4.dp)
            ) {
                Text(
                    text = recipe.strInstructions ?: "",
                    fontSize = 18.sp
                )
            }
        }
    }
}