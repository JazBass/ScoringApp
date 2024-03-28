package com.jazbass.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM GameEntity")
    fun gelAllGames(): Flow<List<GameEntity>>

    @Query("SELECT * FROM GameEntity WHERE id = :id")
    fun getGameById(id: Long) : LiveData<GameEntity>

    @Upsert
     fun upsertGame(gameEntity: GameEntity)

    @Update
    suspend  fun updateGame(gameEntity: GameEntity)

    @Delete
    suspend  fun deleteGame(gameEntity: GameEntity)


    @Query("SELECT * FROM PlayerEntity")
    suspend  fun gelAllPlayers(): MutableList<PlayerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlayer(gameEntity: PlayerEntity)

    @Update
    suspend  fun updatePlayer(gameEntity: PlayerEntity)

    @Delete
    suspend  fun deletePlayer(gameEntity: PlayerEntity)

}