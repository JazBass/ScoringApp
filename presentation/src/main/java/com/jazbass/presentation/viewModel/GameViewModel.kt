package com.jazbass.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jazbass.data.dao.GameEntity
import com.jazbass.data.GameRepository
import com.jazbass.domain.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gameRepository: GameRepository,
) : ViewModel() {

    private val result = MutableLiveData<Any>()
    private val gameSelected = MutableLiveData<Long>()

    fun setGameSelected(id: Long){
        gameSelected.value = id
    }

    fun getGameSelected() : LiveData<GameEntity> = gameRepository.getGameById(gameSelected.value!!)

    fun addGame(gameName: com.jazbass.data.dao.GameEntity) {
        gameRepository.addGame(gameName)
    }

    fun updateGame() {
        gameRepository.updateGame()
    }
}