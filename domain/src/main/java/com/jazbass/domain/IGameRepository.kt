package com.jazbass.domain

import androidx.lifecycle.LiveData
import com.jazbass.data.dao.GameEntity

 public interface IGameRepository {
      fun addGame(gameName: GameEntity)

     fun updateGame()

     fun getGameById(id: Long) : LiveData<GameEntity>

}