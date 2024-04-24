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

    override suspend fun addGame(gameName: GameBusiness): Long {
        return gameDao.insertGame(gameName.toData())
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

    override suspend fun updatePlayer(player: PlayerBusiness) {
        gameDao.updatePlayer(player.toData())
    }


    /** ~~~~~~~~~~~ UTILS ~~~~~~~~~~~ **/


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