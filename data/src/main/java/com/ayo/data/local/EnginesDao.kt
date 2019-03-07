package com.ayo.data.local

import androidx.room.*
import com.ayo.data.local.model.Engine
import com.ayo.data.local.model.Rocket
import kotlinx.coroutines.Deferred

@Dao
interface EnginesDao {

    @Query("SELECT * FROM engines")
    fun getEnginesAsync(): Deferred<List<Engine>>

    @Query("SELECT * FROM engines WHERE id =:id")
    fun getEngine(id: Long?): Deferred<Engine>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEngines(engines: List<Engine>)

}