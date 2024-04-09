package com.jazbass.domain

import kotlinx.coroutines.flow.Flow


 interface IGameRepository {
   suspend fun addGame(gameName: GameBusiness)

    suspend fun updateGame()

     fun getGameById(id: Long): Flow<GameBusiness>

     fun getGamePlayers(gameId: Long): Flow<List<PlayerData>>

}