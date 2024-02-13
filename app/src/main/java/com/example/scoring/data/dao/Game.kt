package com.example.scoring.data.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GameEntity")
data class GameEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var name: String
)

@Entity(tableName = "PlayerEntity")
data class PlayerEntity(
    @PrimaryKey(autoGenerate = true) var id: Long,
    var name: String,
    var score: Long,
    var gameId: Long
)