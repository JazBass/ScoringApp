package com.example.scoring.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface GameDao {

    @Query("SELECT * FROM GameEntity")
    suspend fun gelAllGames(): MutableList<GameEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGame(gameEntity: GameEntity)

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