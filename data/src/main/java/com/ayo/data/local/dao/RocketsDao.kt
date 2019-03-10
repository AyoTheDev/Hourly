package com.ayo.data.local.dao

import androidx.room.*
import com.ayo.data.local.model.RocketData

@Dao
interface RocketsDao {

    @Query("SELECT * FROM rockets")
    suspend fun getRockets(): List<RocketData>

    @Query("SELECT * FROM rockets WHERE rocketid =:id")
    suspend fun getRocket(id: Long?): RocketData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRockets(rockets: List<RocketData>): List<Long>

}