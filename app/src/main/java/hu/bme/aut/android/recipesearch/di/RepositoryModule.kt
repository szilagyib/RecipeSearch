package hu.bme.aut.android.recipesearch.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.android.recipesearch.network.RecipeService
import hu.bme.aut.android.recipesearch.persistence.RecipeDao
import hu.bme.aut.android.recipesearch.ui.main.MainRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideMainRepository(
        recipeService: RecipeService,
        recipeDao: RecipeDao
    ): MainRepository {
        return MainRepository(recipeService, recipeDao)
    }
}