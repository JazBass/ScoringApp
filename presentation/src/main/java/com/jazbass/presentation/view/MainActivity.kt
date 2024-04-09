package com.jazbass.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.jazbass.presentation.GameUIState
import com.jazbass.presentation.navigation.AppNavigation
import com.jazbass.presentation.theme.ScoringTheme
import com.jazbass.presentation.viewModel.GameViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : GameViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViewModel()
        setContent {
            ScoringTheme {
                AppNavigation()
            }
        }
    }

    private fun setUpViewModel(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){

//                viewModel.uiState.collect{ uiState ->
//                    when (uiState){
//                        is GameUIState.Loading -> TODO()
//                        is GameUIState.Success -> TODO()
//                        is GameUIState.Error -> TODO()
//                    }
//                }

//                viewModel.result.collect{result ->
//                    when(result){
//                        is Long -> TODO()
//                        is GameData -> TODO()
//                        else -> TODO()
//                    }
//                }
            }
        }
    }

}
