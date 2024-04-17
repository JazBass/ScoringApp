package com.jazbass.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jazbass.presentation.components.ScoreNote
import com.jazbass.presentation.viewModel.GameViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun GameScreen(
    navController: NavHostController,
    gameViewModel: GameViewModel
) {
    val actualGame = gameViewModel.gameSelected.collectAsState()
    val players = gameViewModel.actualPlayers.collectAsState()
    
    LaunchedEffect(key1 = true) {

    }
    
    Text(text = actualGame.value.name)
    Column(modifier = Modifier.fillMaxWidth()) {
        players.value.let {
            for (player in it){
                ScoreNote(player = player)
            }
        }
    }
}