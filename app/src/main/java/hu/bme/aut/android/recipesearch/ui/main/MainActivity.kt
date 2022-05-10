package hu.bme.aut.android.recipesearch.ui.main

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    internal val viewModel: MainViewModel by viewModels()
}