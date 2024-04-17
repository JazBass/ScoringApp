package com.jazbass.domain

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class GameBusiness(
    var id: Long,
    val name: String
)

data class PlayerBusiness(
    val id: Long,
    val name: String,
    val score: Int,
    val gameId: Long
) {
    private val mutableScore = mutableStateOf(score)
    val actualScore: State<Int> = mutableScore

    fun increaseScore() {
        mutableScore.value++
    }

    fun decreaseScore() {
        mutableScore.value--
    }
}
