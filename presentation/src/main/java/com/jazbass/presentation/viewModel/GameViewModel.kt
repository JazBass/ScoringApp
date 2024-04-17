package com.jazbass.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jazbass.domain.GameBusiness
import com.jazbass.domain.IGameInteractor
import com.jazbass.domain.PlayerBusiness
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gameRepository: IGameInteractor,
) : ViewModel() {

    private val _gameSelected = MutableStateFlow(GameBusiness(0,""))
    val gameSelected = _gameSelected.asStateFlow()

    private val _actualPlayers = MutableStateFlow<List<PlayerBusiness>>(emptyList())
    val actualPlayers = _actualPlayers.asStateFlow()

    private val _result = MutableStateFlow<Any>(0)
    val result = _result.asStateFlow()

//    private val _uiState = MutableStateFlow<GameUIState>(GameUIState.Loading)
//    val uiState: StateFlow<GameUIState> = _uiState

    fun addGame(game: GameBusiness, players: List<PlayerBusiness>) {
         viewModelScope.launch(Dispatchers.IO) {
            try {
                gameRepository.addGame(game).also {gameId ->
                    _gameSelected.value = game.apply { id = gameId }
                    gameRepository.addPlayers(
                        players.map { player ->
                            player.copy(gameId = gameId)
                        }.also {
                            _actualPlayers.value = it
                        }
                    )
                }
            }catch (e: Exception){
                Log.i("Error", e.message!!)
            }
        }
    }



    fun addPlayers(players: List<PlayerBusiness>) {
        viewModelScope.launch {
            gameRepository.addPlayers(players)
            _actualPlayers.value = players
        }
    }

//    fun getPlayers() {
//        viewModelScope.launch {
//            _actualPlayers.value = gameRepository.getGamePlayers(gameId = _gameSelected.value.id)
//        }
//    }
}