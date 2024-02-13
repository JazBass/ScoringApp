package com.example.scoring.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GameEntity::class, PlayerEntity::class], version = 1, exportSchema = false)
abstract class GameDatabase: RoomDatabase() {
    abstract fun gameDao():GameDao
}