package hu.bme.aut.android.recipesearch.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
fun RecipeDetails(recipe: Recipe) {
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
                text = recipe.name,
                fontSize = 28.sp
            )
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .height(120.dp),
                model = recipe.imageUrl,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "user icon"
            )
            for (ingredient in recipe.ingredients) {
                Text(
                    modifier = Modifier
                        .padding(24.dp, 2.dp),
                    text = "• $ingredient",
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
                    text = recipe.instructions,
                    fontSize = 18.sp
                )
            }
        }
    }
}