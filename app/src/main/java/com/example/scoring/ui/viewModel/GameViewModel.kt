package com.example.scoring.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.scoring.data.dao.GameEntity
import com.example.scoring.domain.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gameRepository: GameRepository
): ViewModel() {

      fun addGame() {
        gameRepository.addGame()
    }

      fun updateGame() {
        gameRepository.updateGame()
    }

}