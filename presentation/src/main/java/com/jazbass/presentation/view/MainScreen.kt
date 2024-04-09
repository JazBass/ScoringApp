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

@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: GameViewModel = viewModel()
) {

    val playersCount = remember { mutableIntStateOf(1) }
    var gameName by remember { mutableStateOf("") }
    var playersNames by remember { mutableStateOf("") }

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
                Counter(score = playersCount)
            }
            for (i in 1..playersCount.intValue) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    value = playersNames,
                    onValueChange = { playersNames = it },
                    label = { Text(text = "Player $i") }
                )
            }

            Button(onClick = {
                if (gameName.isNullOrBlank()) {
                    //viewModel.show dialog mutrableState
                   // ShowPopUp("Please select a Game Name")
                }
                GameBusiness(id = 0, name = gameName).also {
                    viewModel.addGame(it)
                }
                navController.navigate("gameScreen/4")
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












