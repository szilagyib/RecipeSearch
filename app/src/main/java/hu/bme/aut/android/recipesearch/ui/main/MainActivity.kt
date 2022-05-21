package hu.bme.aut.android.recipesearch.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.android.recipesearch.model.Recipe

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    internal val viewModel: MainViewModel by viewModels()

    private val testList = mutableListOf<Recipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        //testlist init
        for(i in 0..20)
            testList.add(Recipe.mock())

        super.onCreate(savedInstanceState)
        setContent {
            //RecipeList(testList, Navigation.)
            Navigation(testList)
        }
    }
}