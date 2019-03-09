package com.ayo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ayo.data.db.dao.*
import com.ayo.data.db.model.*

@Database(
    entities = [
        RocketData::class,
        EngineData::class,
        UserData::class,
        ShiftData::class,
        FenceData::class,
        EmployerData::class,
        LocationData::class,
        ContractData::class
    ], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun rocketsDao(): RocketsDao

    abstract fun enginesDao(): EnginesDao

    abstract fun userDao(): UserDao

    abstract fun shiftDao(): ShiftDao

    abstract fun fenceDao(): FenceDao

    abstract fun employerDao(): EmployerDao

    abstract fun locationDao(): LocationDao

    abstract fun contractDao(): ContractDao

}