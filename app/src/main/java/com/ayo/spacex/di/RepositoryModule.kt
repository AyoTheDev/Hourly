package com.ayo.spacex.di

import android.content.Context
import com.ayo.data.local.SharedPrefs
import com.ayo.data.remote.services.RocketsService
import com.ayo.data.repository.RocketsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRocketsRepository(rocketsService: RocketsService, localSource: SharedPrefs): RocketsRepository {
        return RocketsRepository(rocketsService, localSource)
    }

    @Singleton
    @Provides
    fun provideSharedPrefs(context: Context): SharedPrefs {
        return SharedPrefs(context)
    }
}