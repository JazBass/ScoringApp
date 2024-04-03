package com.jazbass.data.repository

import androidx.lifecycle.LiveData
import com.jazbass.data.dao.GameDao
import com.jazbass.data.dao.GameEntity
import com.jazbass.domain.IGameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(private val gameDao: GameDao): IGameRepository {

    val result: Flow<Any> = flow {

    }


    override fun addGame(game: GameEntity) {
        gameDao.upsertGame(game)
    }

    override fun updateGame() {
        TODO("Not yet implemented")
    }

    override fun getGameById(id: Long) : LiveData<GameEntity> = gameDao.getGameById(id)

}