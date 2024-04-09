package com.jazbass.data.repository

import androidx.lifecycle.map
import com.jazbass.data.dao.GameDao
import com.jazbass.domain.GameBusiness
import com.jazbass.domain.IGameRepository
import com.jazbass.domain.PlayerData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(private val gameDao: GameDao) : IGameRepository {

    val result: Flow<Any> = flow {

    }

    override suspend fun addGame(gameName: GameBusiness) {
        TODO("Not yet implemented")
    }

    override suspend fun updateGame() {
        TODO("Not yet implemented")
    }

    override fun getGameById(id: Long): Flow<GameBusiness> {
        return gameDao.getGameById(id).map {
            it.toDomain()
        }
    }


    override fun getGamePlayers(gameId: Long): Flow<List<PlayerData>> {
        return gameDao.getAllPlayers().map { playerList ->
            playerList.map {
                PlayerData(
                    id = it.id,
                    score = it.score.toInt(),
                    name = it.name,
                    gameId = it.gameId
                )
            }
        }
    }
}