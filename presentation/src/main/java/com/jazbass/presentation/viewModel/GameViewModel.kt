package com.jazbass.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jazbass.domain.IGameRepository
import com.jazbass.presentation.GameData
import com.jazbass.presentation.GameUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gameRepository: IGameRepository,
) : ViewModel() {

    private val gameSelected = MutableLiveData<Long>()

    private val _result = MutableStateFlow<Any>(0)
    val result: StateFlow<Any> = _result

    private val _uiState = MutableStateFlow<GameUIState>(GameUIState.Loading)
    val uiState: StateFlow<GameUIState> = _uiState

    fun setGameSelected(id: Long) {
        gameSelected.value = id
    }

    fun getGameSelected(): LiveData<GameData> = gameRepository.getGameById(gameSelected.value!!)

    fun addGame(
        gameName: GameData
    ) {
        gameRepository.addGame(gameName)
    }

    fun updateGame() {
        gameRepository.updateGame()
    }

    private fun executeAction(){
        viewModelScope.launch {

        }
    }
}