package com.ayo.data.db.dao

import androidx.room.*
import com.ayo.data.db.model.ContractData

@Dao
interface ContractDao {

    @Query("SELECT * FROM contracts where userId =:userId")
    suspend fun getContractsForUser(userId: Long): List<ContractData>

    @Query("SELECT * FROM contracts WHERE id =:id")
    suspend fun getContract(id: Long?): ContractData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addContract(contract: ContractData): Long

}