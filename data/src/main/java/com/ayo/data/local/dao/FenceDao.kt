package com.ayo.data.local.dao

import androidx.room.*
import com.ayo.data.local.model.FenceData

@Dao
interface FenceDao {

    @Query("SELECT * FROM fences")
    suspend fun getFences(): List<FenceData>

    @Query("SELECT * FROM fences WHERE id =:id")
    suspend fun getFence(id: Long?): FenceData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFences(fences: List<FenceData>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFence(fence: FenceData): Long

}