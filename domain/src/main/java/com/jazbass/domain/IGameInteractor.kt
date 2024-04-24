package com.jazbass.domain

import kotlinx.coroutines.flow.Flow


interface IGameInteractor {
    suspend fun addGame(gameName: GameBusiness): Long

    fun getGameById(id: Long): Flow<GameBusiness>

    fun getGamePlayers(gameId: Long): Flow<List<PlayerBusiness>>

    suspend fun addPlayers(playerList: List<PlayerBusiness>)

    suspend fun updatePlayer(player: PlayerBusiness)

}