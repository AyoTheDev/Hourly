package com.ayo.data.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "contracts",
    foreignKeys = [
        ForeignKey(
            entity = UserData::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("userId"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = EmployerData::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("employerId")
        )
    ],
    indices = [Index(value = ["employerId"])]
)
data class ContractData(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val wage: Int? = null,
    val currency: String? = null,
    val breaksEnabled: Boolean = false,
    val breakSettingMinutes: Int?,
    val breakSettingHoursInMinutes: Int?,
    val userId: Long?,
    val employerId: Long?
) : Parcelable