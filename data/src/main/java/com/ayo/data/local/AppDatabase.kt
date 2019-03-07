package com.ayo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ayo.data.local.model.Engine
import com.ayo.data.local.model.Rocket

/**
 * Created by Dimitris Konomis (konomis.dimitris@gmail.com) on 13/11/2018.
 **/

@Database(entities = [Rocket::class, Engine::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun rocketsDao(): RocketsDao

    abstract fun enginesDao(): EnginesDao

}