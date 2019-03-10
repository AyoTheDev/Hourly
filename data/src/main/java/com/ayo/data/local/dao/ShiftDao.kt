package com.ayo.data.local.dao

import androidx.room.*
import com.ayo.data.local.model.ShiftData

@Dao
interface ShiftDao {

    @Query("SELECT * FROM shifts where userId = :userId")
    suspend fun getShiftsForUser(userId: String): List<ShiftData>

    @Query("SELECT * FROM shifts WHERE id =:id")
    suspend fun getShift(id: Long): ShiftData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShifts(shifts: List<ShiftData>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShift(shifts: ShiftData): Long

}