package com.jazbass.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.jazbass.presentation.navigation.AppNavigation
import com.jazbass.presentation.theme.ScoringTheme
import com.jazbass.presentation.viewModel.GameViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : GameViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScoringTheme {
                AppNavigation()
            }
        }
    }

}
