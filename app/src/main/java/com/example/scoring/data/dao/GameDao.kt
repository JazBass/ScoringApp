package com.example.scoring.data.dao

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