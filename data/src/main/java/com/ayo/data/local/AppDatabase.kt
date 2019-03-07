package com.ayo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ayo.data.local.model.Engine
import com.ayo.data.local.model.Rocket

@Database(entities = [Rocket::class, Engine::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun rocketsDao(): RocketsDao

    abstract fun enginesDao(): EnginesDao

}