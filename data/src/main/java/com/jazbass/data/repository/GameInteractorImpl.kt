package com.jazbass.data.repository

import com.jazbass.data.dao.GameDao
import com.jazbass.data.dao.GameEntity
import com.jazbass.data.dao.PlayerEntity
import com.jazbass.domain.GameBusiness
import com.jazbass.domain.IGameInteractor
import com.jazbass.domain.PlayerBusiness
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(private val gameDao: GameDao) : IGameInteractor {

    val result: Flow<Any> = flow {

    }

    override suspend fun addGame(gameName: GameBusiness): Long {
        return gameDao.upsertGame(gameName.toData())
    }


    override fun getGameById(id: Long): Flow<GameBusiness> {
        return gameDao.getGameById(id).map {
            it.toDomain()
        }
    }


    override fun getGamePlayers(gameId: Long): Flow<List<PlayerBusiness>> {
        return gameDao.getGamePlayers(gameId).map { playerList ->
            playerList.map {
                PlayerBusiness(
                    id = it.id,
                    score = it.score.toInt(),
                    name = it.name,
                    gameId = it.gameId
                )
            }
        }
    }

    override suspend fun addPlayers(playerList: List<PlayerBusiness>) {
        for (player in playerList) {
            gameDao.addPlayer(player.toData())
        }
    }

    private fun PlayerBusiness.toData(): PlayerEntity {
        return PlayerEntity(
            this.id,
            this.name,
            this.score.toLong(),
            this.gameId
        )
    }

    private fun GameBusiness.toData(): GameEntity {
        return GameEntity(
            this.id,
            this.name
        )
    }

}