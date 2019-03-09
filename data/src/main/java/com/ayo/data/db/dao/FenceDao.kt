package com.ayo.data.db.dao

import androidx.room.*
import com.ayo.data.db.model.FenceData
import com.ayo.data.db.model.UserData

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