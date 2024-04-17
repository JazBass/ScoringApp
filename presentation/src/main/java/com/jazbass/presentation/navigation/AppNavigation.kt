package com.jazbass.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jazbass.presentation.view.GameScreen
import com.jazbass.presentation.view.MainScreen
import com.jazbass.presentation.viewModel.GameViewModel

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    val viewModel = hiltViewModel<GameViewModel>()
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route){

        composable(route = AppScreens.MainScreen.route){
            MainScreen(navController, viewModel)
        }

        composable(
            route = AppScreens.GameScreen.route
        ){
            GameScreen(navController, viewModel)
        }
    }
}