package com.example.scoring.di

import android.content.Context
import androidx.room.Room
import com.example.scoring.data.dao.GameDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    const val GAME_DATABASE_NAME = "gameDatabase "

    @Singleton
    @Provides
    fun provideGameDatabase(@ApplicationContext appContext: Context): GameDatabase =
        Room.databaseBuilder(
            appContext,
            GameDatabase::class.java,
            GAME_DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideGameDao(db: GameDatabase) = db.gameDao()

}