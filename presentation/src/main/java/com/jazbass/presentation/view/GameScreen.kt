package com.jazbass.presentation.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jazbass.presentation.components.ScoreNote
import com.jazbass.presentation.components.TopBar
import com.jazbass.presentation.viewModel.GameViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun GameScreen(
    navController: NavHostController,
    viewModel: GameViewModel
) {
    val actualGame = viewModel.gameSelected.collectAsState()
    val players = viewModel.actualPlayers.collectAsState()
    val showInputDialog = viewModel.showDialog.collectAsState()

    Scaffold(
        topBar = { TopBar(title = actualGame.value.name) },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
         //TODO nueva mano
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            players.value.let {
                for (player in it) {
                    ScoreNote(player = player)
                }
            }
            Button(onClick = { viewModel.showDialog() }) {
                Text(text = "Add player")
            }

        }

        if (showInputDialog.value) {
            var newPlayerName by remember { mutableStateOf("") }

            AlertDialog(
                onDismissRequest = { viewModel.hideDialog() },
                dismissButton = {
                    TextButton(
                        onClick = { viewModel.hideDialog() }
                    ) {
                        Text(text = "Cancel")
                    }
                },
                confirmButton = {
                    Button(onClick = {
                        viewModel.addNewPlayer(newPlayerName)
                    }) {
                        Text(text = "Add")
                    }
                },
                text = {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        value = newPlayerName,
                        onValueChange = {
                            newPlayerName = it
                        },
                        label = { Text(text = "Player name") }
                    )
                }
            )
        }

    }
}

@Preview
@Composable
fun DialogPreview() {
    AlertDialog(
        title = { Text(text = "Player name", modifier = Modifier.padding(horizontal = 8.dp)) },
        onDismissRequest = { },
        dismissButton = {
            TextButton(
                onClick = {}
            ) {
                Text(text = "Cancel")
            }
        },
        confirmButton = {
            Button(onClick = {

            }) {
                Text(text = "Add")
            }
        },
        text = {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = "",
                onValueChange = {
                },
                label = { Text(text = "Hola") }
            )
        }
    )
}



