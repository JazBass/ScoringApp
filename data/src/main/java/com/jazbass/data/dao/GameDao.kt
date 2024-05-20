package com.jazbass.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.jazbass.domain.GameBusiness
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM GameEntity")
    fun gelAllGames(): Flow<List<GameEntity>>

    @Query("SELECT * FROM GameEntity WHERE id = :id")
    fun getGameById(id: Long) :Flow<GameEntity>

    @Insert
     fun insertGame(gameEntity: GameEntity) : Long

    @Update
    suspend fun updateGame(gameEntity: GameEntity)

    @Delete
    suspend fun deleteGame(gameEntity: GameEntity)

    /** ~~~~~~~~~~ PLAYERS ~~~~~~~~~~ **/

    @Query("SELECT * FROM PlayerEntity WHERE gameId= :gameId")
    fun getGamePlayers(gameId: Long): Flow<List<PlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlayer(playerEntity: PlayerEntity)

    @Update
    suspend fun updatePlayer(playerEntity: PlayerEntity)

    @Delete
    suspend fun deletePlayer(playerEntity: PlayerEntity)

}