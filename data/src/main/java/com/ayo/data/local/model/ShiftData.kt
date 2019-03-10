package com.ayo.data.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "shifts",
    foreignKeys = [
        ForeignKey(
            entity = EmployerData::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("employerId")
        ),
        ForeignKey(
            entity = UserData::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("userId"),
            onDelete = ForeignKey.CASCADE

        ),
        ForeignKey(
            entity = ContractData::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("contractId")

        )
    ],
    indices = [Index(value = ["userId"]), Index(value = ["employerId"]), Index(value = ["contractId"])]
)
data class ShiftData(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val employerId: Long?,
    val userId: Long?,
    val contractId: Long?,
    val timeWorked: Long?,
    val breakTime: Long?,
    val start: Long?,
    val finish: Long?,
    val isComplete: Boolean?,
    val addedManually: Boolean?,
    val wage: Int?
) : Parcelable