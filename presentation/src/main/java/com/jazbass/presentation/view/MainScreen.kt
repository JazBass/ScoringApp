package com.jazbass.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.jazbass.presentation.components.Counter
import com.jazbass.presentation.viewModel.GameViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jazbass.domain.GameBusiness
import com.jazbass.domain.PlayerBusiness

@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: GameViewModel = viewModel()
) {

    var playersCount by remember { mutableStateOf(2) }
    var gameName by remember { mutableStateOf("") }
    val playersNames = remember { mutableListOf<String>() }

    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = gameName,
                onValueChange = { gameName = it },
                label = { Text(text = "Game") }
            )
            Row {
                Text(text = "Players amount")
                Button(onClick = { if (playersCount > 1) playersCount-- }) {
                    Text(text = "-")
                }
                Text(text = playersCount.toString())
                Button(onClick = { playersCount++ }) {
                    Text(text = "+")
                }
            }
            repeat(playersCount) { i ->
                if (playersNames.size < playersCount) playersNames.add(i, "")
                var playerName by remember { mutableStateOf("") }
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    value = playerName,
                    onValueChange = { newValue ->
                        playerName = newValue
                        playersNames.set(i, newValue)
                    },
                    label = { Text(text = "Player ${i + 1}") }
                )

            }
            Button(
                onClick = {
                    GameBusiness(id = 0, name = gameName).also {
                        viewModel.addGame(
                            game = it,
                            players = playersNames.map { playerName ->
                                PlayerBusiness(0, playerName, 0, 0)
                            }
                        )
                    }
//                    playersNames.value.map { playerName ->
//                        PlayerBusiness(0L, playerName, 0, 0)
//                    }.also {
//                        viewModel.addPlayers(it)
//                    }
                    navController.navigate("gameScreen")
                }) {
                Text(text = "Start Game")
            }
        }
    }
}

@Composable
fun ShowPopUp(msge: String) {
    Dialog({}) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = msge,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(),
                textAlign = TextAlign.Center
            )
        }
    }
}












