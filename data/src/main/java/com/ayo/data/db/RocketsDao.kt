package com.ayo.data.db

import androidx.room.*
import com.ayo.data.db.model.RocketData

@Dao
interface RocketsDao {

    @Query("SELECT * FROM rockets")
    suspend fun getRockets(): List<RocketData>

    @Query("SELECT * FROM rockets WHERE rocketid =:id")
    suspend fun getRocket(id: Long?): RocketData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRockets(rockets: List<RocketData>)

}