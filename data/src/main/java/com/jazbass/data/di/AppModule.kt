package com.jazbass.data.di

import android.content.Context
import androidx.room.Room
import com.jazbass.data.dao.GameDao
import com.jazbass.data.dao.GameDatabase
import com.jazbass.data.repository.GameRepositoryImpl
import com.jazbass.domain.IGameInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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

    @Singleton
    @Provides
    fun providesGameRepository(gameDao: GameDao) : IGameInteractor {
        return GameRepositoryImpl(gameDao)
    }

}