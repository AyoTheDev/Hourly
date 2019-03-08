package com.ayo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ayo.data.db.model.EngineData
import com.ayo.data.db.model.RocketData

@Database(entities = [RocketData::class, EngineData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun rocketsDao(): RocketsDao

    abstract fun enginesDao(): EnginesDao

}