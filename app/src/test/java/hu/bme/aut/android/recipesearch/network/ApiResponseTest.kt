package hu.bme.aut.android.recipesearch.network

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.SandwichInitializer
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.CoreMatchers.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@RunWith(JUnit4::class)
class ApiResponseTest {

    @Test
    fun exception() {
        val exception = Exception("test")
        val apiResponse = ApiResponse.error<String>(exception)
        assertThat(apiResponse.message, `is`("test"))
    }

    @Test
    fun success() {
        val apiResponse =
            ApiResponse.of(SandwichInitializer.successCodeRange) { Response.success("test") }
        if (apiResponse is ApiResponse.Success) {
            assertThat(apiResponse.data, `is`("test"))
        }
    }
}