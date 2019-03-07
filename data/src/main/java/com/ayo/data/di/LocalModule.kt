package com.ayo.data.di

import android.content.Context
import androidx.room.Room
import com.ayo.data.local.AppDatabase
import com.ayo.data.local.RocketsDao
import dagger.Module
import dagger.Provides

//todo rename to DatabaseModule?
@Module
class LocalModule {

    @Provides
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "spaceX.db").build()
    }

    @Provides
    fun provideRocketsDao(database: AppDatabase) : RocketsDao {
        return database.rocketsDao()
    }

}