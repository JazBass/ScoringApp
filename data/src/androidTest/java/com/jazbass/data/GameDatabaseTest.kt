package com.jazbass.data

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class GameDatabaseTest {

    private lateinit var database: com.jazbass.data.dao.GameDatabase
    @Before
    fun initDB(){
        database = Room.inMemoryDatabaseBuilder(//Faster for test
            getApplicationContext(),
            com.jazbass.data.dao.GameDatabase::class.java
        ).allowMainThreadQueries().build()
    }

    @Test
    fun insertGameAndGetIt() = runTest {
        val game = com.jazbass.data.dao.GameEntity(
            name = "Tests"
        )
        database.gameDao().upsertGame(game)
        val games = database.gameDao().gelAllGames().first()

        assertEquals(1, games.size)
        assertEquals(game.name, games[0].name)
    }
}