package com.jazbass.data.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jazbass.domain.GameBusiness

@Entity(tableName = "GameEntity")
data class GameEntity(//data
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Long = 0,
    @ColumnInfo(name = "name") var name: String
){
    fun toDomain(): GameBusiness{
        return GameBusiness(
            id = this.id,
            name = this.name
        )
    }
}

@Entity(tableName = "PlayerEntity")
data class PlayerEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Long = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "score") var score: Long,
    var gameId: Long
)