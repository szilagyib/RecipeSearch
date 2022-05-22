package hu.bme.aut.android.recipesearch

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import hu.bme.aut.android.recipesearch.ui.details.DetailsViewModel
import hu.bme.aut.android.recipesearch.ui.details.RecipeDetails
import hu.bme.aut.android.recipesearch.ui.main.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class RecipeActivityTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var activity: MainActivity

    @Before
    fun init() {
        composeTestRule.activityRule.scenario.onActivity {
            activity = it
        }
    }

    @Test
    fun recipeDetailsLoadingTest() {
        composeTestRule.setContent {
            val viewModel = hiltViewModel<DetailsViewModel>()
            viewModel.loadRecipeById(52777)

            RecipeDetails(52777, viewModel)
        }

        /*composeTestRule
            .onNodeWithText("Mediterranean Pasta Salad", useUnmergedTree = true)
            .assertIsDisplayed()*/
    }

}