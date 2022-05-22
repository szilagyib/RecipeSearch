package hu.bme.aut.android.recipesearch.persistence

import hu.bme.aut.android.recipesearch.model.Recipe
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.hamcrest.CoreMatchers.`is`

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class RecipeDaoTest : LocalDatabase() {

    private lateinit var recipeDao: RecipeDao

    @Before
    fun init() {
        recipeDao = db.recipeDao()
    }

    @Test
    fun insertAndLoadRecipesTest() = runBlocking {
        val mockDataList = listOf(Recipe.mock())
        recipeDao.insertRecipeList(mockDataList)

        val loadFromDB = recipeDao.getRecipeList()
        assertThat(loadFromDB.toString(), `is`(mockDataList.toString()))

        val mockData = Recipe.mock()
        assertThat(loadFromDB[0].toString(), `is`(mockData.toString()))
    }
}