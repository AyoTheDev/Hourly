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
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("rocketId"),
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["rocketId"])]
)
data class Engine(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val rocketId: Long? = 0,
    val number: Int? = 0
) : Parcelable