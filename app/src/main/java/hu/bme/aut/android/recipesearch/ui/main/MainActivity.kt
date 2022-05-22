package hu.bme.aut.android.recipesearch.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.android.recipesearch.model.Recipe

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @VisibleForTesting
    internal val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation(viewModel)
        }
    }
}