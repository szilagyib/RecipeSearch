package hu.bme.aut.android.recipesearch.ui.main
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.key.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import hu.bme.aut.android.recipesearch.R
import hu.bme.aut.android.recipesearch.model.Recipe
import hu.bme.aut.android.recipesearch.ui.details.RecipeDetails

@Composable
fun RecipeListItem(recipe: Recipe, onItemClick: (Recipe) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .height(60.dp)
            .background(Color.White)
            .clickable(onClick = { onItemClick(recipe) })
    ) {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = recipe.strMealThumb,
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "user icon",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(CenterVertically)
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(CenterVertically),
                text = recipe.strMeal,
                fontSize = 22.sp
            )
        }
    }
}

@Composable
fun RecipeList(r: List<Recipe>, navController: NavController, viewModel: MainViewModel) {
    val recipes: List<Recipe> by viewModel.recipeList.collectAsState(initial = r)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.custom_green))) {
        items(recipes) {
                recipe -> RecipeListItem(recipe) {
                    selected -> navController
                        .navigate("details/${selected.idMeal}") {
                            popUpTo("main") {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                    }
                }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(state: MutableState<TextFieldValue>, viewModel: MainViewModel) {
    val requester = remember { FocusRequester() }
    TextField(
        value = state.value,
        onValueChange = { value -> state.value = value },
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.custom_green))
            .onKeyEvent {
                if (it.key == Key.Enter) {
                    viewModel.recipeName = state.value.toString()
                    state.value = TextFieldValue("")
                    true
                } else false
            }
            .focusRequester(requester)
            .focusable()
            .padding(4.dp),
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 18.sp
        ),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "search icon",
                modifier = Modifier
                    .padding(12.dp)
                    .size(28.dp)
            )
        },
        trailingIcon = {
            IconButton(
                onClick = { state.value = TextFieldValue("") }
            ) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "close icon",
                    modifier = Modifier
                        .padding(12.dp)
                        .size(28.dp)
                )
            }
        },
        singleLine = true,
        shape = RectangleShape,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            cursorColor = Color.Black,
            leadingIconColor = Color.Black,
            trailingIconColor = Color.Black,
            backgroundColor = Color.White
        )
    )
}

@Composable
fun Navigation(viewModel : MainViewModel) {
    val recipes: List<Recipe> by viewModel.recipeList.collectAsState(initial = listOf())
    val navController = rememberNavController()
    val textState = remember { mutableStateOf(TextFieldValue("")) }

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            Column {
                SearchBar(textState, viewModel)
                RecipeList(recipes, navController, viewModel)
            }
        }
        composable(
            "details/{recipeId}",
            arguments = listOf(navArgument("recipeId") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("recipeId")?.let { recipeId ->
                RecipeDetails(recipeId.toLong(), hiltViewModel())
            }
        }
    }
}
