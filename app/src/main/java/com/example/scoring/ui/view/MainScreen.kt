package com.example.scoring.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.scoring.ui.navigation.AppScreens

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Button(onClick = { navController.navigate("gameScreen/4") }) {
                Text(text = "Navigate")
            }
        }
    }
}
