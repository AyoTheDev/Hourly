package com.ayo.data.local

import androidx.room.*
import com.ayo.data.local.model.Rocket
import kotlinx.coroutines.Deferred

@Dao
interface RocketsDao {

    @Query("SELECT * FROM rockets")
    suspend fun getRockets(): List<Rocket>

    @Query("SELECT * FROM rockets WHERE rocketid =:id")
    suspend fun getRocket(id: Long?): Rocket

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRockets(rockets: List<Rocket>)

}