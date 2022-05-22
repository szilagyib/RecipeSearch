package hu.bme.aut.android.recipesearch.ui.details

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailsRepository: DetailsRepository
) : ViewModel() {

    private val recipeIdSharedFlow: MutableSharedFlow<Long> = MutableSharedFlow(replay = 1)

    @OptIn(ExperimentalCoroutinesApi::class)
    val recipeDetailsFlow = recipeIdSharedFlow.flatMapLatest {
        detailsRepository.getRecipeById(it)
    }

    fun loadRecipeById(id: Long) = recipeIdSharedFlow.tryEmit(id)
}