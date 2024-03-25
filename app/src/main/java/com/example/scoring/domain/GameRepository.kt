package com.example.scoring.domain

import com.example.scoring.data.dao.GameDao
import com.example.scoring.data.dao.GameEntity
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameDao: GameDao): IGameRepository {
    override  fun addGame() {
        gameDao.upsertGame(GameEntity(1,"s"))
    }

    override  fun updateGame() {
        TODO("Not yet implemented")
    }
}