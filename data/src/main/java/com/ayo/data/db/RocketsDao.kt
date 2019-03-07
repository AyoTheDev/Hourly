package com.ayo.data.db

import androidx.room.*
import com.ayo.data.db.model.Rocket

@Dao
interface RocketsDao {

    @Query("SELECT * FROM rockets")
    suspend fun getRockets(): List<Rocket>

    @Query("SELECT * FROM rockets WHERE rocketid =:id")
    suspend fun getRocket(id: Long?): Rocket

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRockets(rockets: List<Rocket>)

}