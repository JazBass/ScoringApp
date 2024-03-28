package com.jazbass.domain

import androidx.lifecycle.LiveData
import com.jazbass.data.dao.GameDao
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameDao: GameDao): IGameRepository {
    override fun addGame(game: com.jazbass.data.dao.GameEntity) {
        gameDao.upsertGame(game)
    }

    override fun updateGame() {
        TODO("Not yet implemented")
    }

    override fun getGameById(id: Long) : LiveData<com.jazbass.data.dao.GameEntity> = gameDao.getGameById(id)

}