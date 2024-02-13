package com.example.scoring.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.scoring.ui.view.GameScreen
import com.example.scoring.ui.view.MainScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route){
        composable(AppScreens.MainScreen.route){
            MainScreen(navController)
        }
        composable(
            route = AppScreens.GameScreen.route,
            arguments = listOf(navArgument("gameId"){type = NavType.IntType})
        ){backStackEntry ->
            val gameId = backStackEntry.arguments?.getInt("gameId")
            requireNotNull(gameId) { "Id can not be null" }
            GameScreen(gameId, navController)
        }
    }
}