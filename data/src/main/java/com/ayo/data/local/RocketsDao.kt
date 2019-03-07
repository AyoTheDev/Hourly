package com.ayo.data.local

import androidx.room.*
import com.ayo.data.local.model.Rocket
import kotlinx.coroutines.Deferred

@Dao
interface RocketsDao {

    @Query("SELECT * FROM rockets")
    fun getRocketsAsync(): Deferred<List<Rocket>?>

    @Query("SELECT * FROM rockets WHERE id =:id")
    fun getRocket(id: Long?): Deferred<Rocket?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRockets(rockets: List<Rocket>)

}