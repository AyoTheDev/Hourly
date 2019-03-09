package com.ayo.data.di

import android.content.Context
import androidx.room.Room
import com.ayo.data.db.AppDatabase
import com.ayo.data.db.dao.*
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "hourly.db").build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideShiftDao(database: AppDatabase): ShiftDao {
        return database.shiftDao()
    }

    @Provides
    fun provideFenceDao(database: AppDatabase): FenceDao {
        return database.fenceDao()
    }
    @Provides
    fun provideEmployerDao(database: AppDatabase): EmployerDao {
        return database.employerDao()
    }

    @Provides
    fun provideLocationDao(database: AppDatabase): LocationDao {
        return database.locationDao()
    }

    @Provides
    fun provideContractDao(database: AppDatabase): ContractDao{
        return database.contractDao()
    }

    @Provides
    fun provideRocketsDao(database: AppDatabase): RocketsDao {
        return database.rocketsDao()
    }

}