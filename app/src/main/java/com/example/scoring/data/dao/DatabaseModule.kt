package com.example.scoring.data.dao

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideGameDao(gameDatabase: GameDatabase): GameDao {
        return gameDatabase.gameDao()
    }

    @Provides
    @Singleton
    fun provideGameDatabase(@ApplicationContext appContext: Context): GameDatabase {
        return Room.databaseBuilder(
            appContext,
            GameDatabase::class.java,
            "GameScoringDB"
        ).build()
    }

}