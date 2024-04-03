package com.jazbass.presentation

sealed class GameUIState {

    object Loading : GameUIState()
    data class Success(val id: Long) : GameUIState()
    data class Error(val msg: String) : GameUIState()
}