package com.ayo.data.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "locations",
    foreignKeys = [
        ForeignKey(
            entity = EmployerData::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("employerId")
        )
    ],
    indices = [Index(value = ["employerId"])]
)
data class LocationData(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val lat: Double?,
    val lng: Double?,
    val radius: Double?,
    val employerId: Long?,
    val address: String?,
    //these will constantly be updating...
    val clockInFenceId: Long?,
    val clockOutFenceId: Long?

) : Parcelable