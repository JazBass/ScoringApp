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
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gameRepository: IGameInteractor,
) : ViewModel() {

    private val _gameSelected = MutableStateFlow(GameBusiness(0, ""))
    val gameSelected = _gameSelected.asStateFlow()

    private val _actualPlayers = MutableStateFlow<List<PlayerBusiness>>(emptyList())
    val actualPlayers = _actualPlayers.asStateFlow()

    private val _result = MutableStateFlow<Any>(0)
    val result = _result.asStateFlow()

    private val _showDialog = MutableStateFlow(false)
    val showDialog = _showDialog.asStateFlow()

//    private val _uiState = MutableStateFlow<GameUIState>(GameUIState.Loading)
//    val uiState: StateFlow<GameUIState> = _uiState

    fun showDialog() {
        _showDialog.value = true
    }

    fun hideDialog() {
        _showDialog.value = false
    }

    fun addGame(game: GameBusiness, players: List<PlayerBusiness>) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newGameId = gameRepository.addGame(game)
                _gameSelected.value = game.apply { id = newGameId }
                gameRepository.addPlayers(
                    players.map { player ->
                        player.copy(gameId = newGameId).also {
                            Log.i("Player", "PlayerName: ${it.name} id: ${it.gameId}")
                        }
                    }
                )
                getPlayers()
            } catch (e: Exception) {
                Log.i("Error", e.toString())
            }
        }
    }

    fun updatePlayer(player: PlayerBusiness) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                gameRepository.updatePlayer(player)
            } catch (e: Exception) {
                Log.i("Error", e.toString())
            }
        }
    }

    fun addPlayers(players: List<PlayerBusiness>) {
        viewModelScope.launch(Dispatchers.IO) {
            gameRepository.addPlayers(players)
            _actualPlayers.value = players
        }
    }

    fun addNewPlayer(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            PlayerBusiness(0, name, 0, _gameSelected.value.id).let {
                val playerList = listOf(it).also { playerList ->
                    Log.i("List", playerList[0].name)
                    gameRepository.addPlayers(playerList)
                }
            }
        }
        getPlayers()
        _showDialog.value = false
    }

    private fun getPlayers() {
        viewModelScope.launch(Dispatchers.IO) {
            gameRepository.getGamePlayers(gameId = _gameSelected.value.id).collect { players ->
                _actualPlayers.value = players
            }
        }
    }
}