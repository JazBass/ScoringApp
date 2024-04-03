package com.jazbass.scoring.di

import com.jazbass.data.dao.GameDao
import com.jazbass.data.repository.GameRepositoryImpl
import com.jazbass.domain.IGameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesGameRepository(gameDao: GameDao) : IGameRepository{
        return GameRepositoryImpl(gameDao)
    }
}