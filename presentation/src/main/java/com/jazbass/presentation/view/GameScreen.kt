package com.jazbass.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.navigation.NavHostController
import com.jazbass.presentation.components.ScoreNote

@SuppressLint("UnrememberedMutableState")
@Composable
fun GameScreen(gameId: Int, navController: NavHostController){
    Column{
        ScoreNote(name = "Javier", score = mutableIntStateOf(4))
        ScoreNote(name = "Pepe", score = mutableIntStateOf(4))
    }
}