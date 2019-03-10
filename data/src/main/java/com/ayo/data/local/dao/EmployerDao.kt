package com.ayo.data.local.dao

import androidx.room.*
import com.ayo.data.local.model.EmployerData

@Dao
interface EmployerDao {

    @Query("SELECT * FROM employers WHERE id =:id")
    suspend fun getEmployer(id: Long?): EmployerData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEmployer(employer: EmployerData): Long

}