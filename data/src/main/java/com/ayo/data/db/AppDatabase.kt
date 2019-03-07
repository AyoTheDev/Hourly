package com.ayo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ayo.data.db.model.Engine
import com.ayo.data.db.model.Rocket

@Database(entities = [Rocket::class, Engine::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun rocketsDao(): RocketsDao

    abstract fun enginesDao(): EnginesDao

}