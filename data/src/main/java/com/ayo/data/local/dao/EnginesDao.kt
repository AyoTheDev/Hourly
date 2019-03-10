package com.ayo.data.local.dao

import androidx.room.*
import com.ayo.data.local.model.EngineData

@Dao
interface EnginesDao {

    @Query("SELECT * FROM engines")
    suspend fun getEnginesAsync(): List<EngineData>

    @Query("SELECT * FROM engines WHERE id =:id")
    suspend fun getEngine(id: Long?): EngineData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEngines(engines: List<EngineData>)

}