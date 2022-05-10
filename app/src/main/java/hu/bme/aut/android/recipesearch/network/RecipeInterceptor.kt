package hu.bme.aut.android.recipesearch.network

import okhttp3.Interceptor
import okhttp3.Response

class RecipeInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}