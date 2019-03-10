package com.ayo.data.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "fences",
    foreignKeys = [
        ForeignKey(
            entity = LocationData::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("locationId"),
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["locationId"])]
)
data class FenceData(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val enter: Boolean?,
    val locationId: Long?
) : Parcelable