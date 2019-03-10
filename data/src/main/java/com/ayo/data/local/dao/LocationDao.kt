package com.ayo.data.local.dao

import androidx.room.*
import com.ayo.data.local.model.LocationData

@Dao
interface LocationDao {

    @Query("SELECT * FROM locations")
    suspend fun getLocations(): List<LocationData>

    @Query("SELECT * FROM locations WHERE id =:id")
    suspend fun getLocation(id: Long?): LocationData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLocation(location: LocationData): Long

}