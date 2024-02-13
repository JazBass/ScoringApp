package com.example.scoring.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.scoring.ui.components.ScoreNote

@Composable
fun GameScreen(gameId: Int, navController: NavHostController){
    Column{
        ScoreNote(name = "Javier", score = 5)
        ScoreNote(name = "Pepe", score = 4)
    }
}