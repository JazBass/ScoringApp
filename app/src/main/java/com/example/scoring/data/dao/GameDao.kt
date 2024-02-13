package com.example.scoring.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GameDao {

    @Query("SELECT * FROM GameEntity")
    fun gelAllGames(): MutableList<GameEntity>

    @Insert
    fun addGame(gameEntity: GameEntity)

    @Update
    fun updateGame(gameEntity: GameEntity)

    @Delete
    fun deleteGame(gameEntity: GameEntity)


    @Query("SELECT * FROM PlayerEntity")
    fun gelAllPlayers(): MutableList<GameEntity>

    @Insert
    fun addPlayer(gameEntity: GameEntity)

    @Update
    fun updatePlayer(gameEntity: GameEntity)

    @Delete
    fun deletePlayer(gameEntity: GameEntity)

}