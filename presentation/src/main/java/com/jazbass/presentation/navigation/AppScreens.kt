package com.jazbass.presentation.navigation

sealed class AppScreens(val route: String) {
    data object MainScreen: AppScreens("mainScreen")
    data object GameScreen: AppScreens("gameScreen/{gameId}")
}