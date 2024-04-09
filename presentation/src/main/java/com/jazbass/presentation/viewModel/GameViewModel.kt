package com.jazbass.presentation.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jazbass.domain.GameBusiness
import com.jazbass.domain.IGameRepository
import com.jazbass.presentation.GameUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
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

    fun getGameSelected(): Flow<GameBusiness> = gameRepository.getGameById(gameSelected.value!!)

    fun addGame(gameData: GameBusiness) {
        executeAction(gameData) { gameRepository.addGame(gameData) }
    }

    fun updateGame(gameData: GameBusiness) {
        executeAction(gameData) { gameRepository.updateGame() }
    }

    private fun executeAction(gameData: GameBusiness, block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                block()
                _result.value = gameData
            }catch (e: Exception){
                Log.i("Error", e.message!!)
            }
        }
    }
}