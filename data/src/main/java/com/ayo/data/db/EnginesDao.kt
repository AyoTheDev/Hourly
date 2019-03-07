package com.ayo.data.db

import androidx.room.*
import com.ayo.data.db.model.Engine

@Dao
interface EnginesDao {

    @Query("SELECT * FROM engines")
    suspend fun getEnginesAsync(): List<Engine>

    @Query("SELECT * FROM engines WHERE id =:id")
    suspend fun getEngine(id: Long?): Engine

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEngines(engines: List<Engine>)

}