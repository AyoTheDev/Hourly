package com.ayo.data.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "engines",
    foreignKeys = [ForeignKey(
        entity = Rocket::class,
        parentColumns = arrayOf("rocketid"),
        childColumns = arrayOf("rocketid"),
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["rocketid"])]
)
data class Engine(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val rocketid: Long? = 0,
    val number: Int? = 0
) : Parcelable