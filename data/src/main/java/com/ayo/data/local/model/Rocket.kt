package com.ayo.data.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "rockets", indices = [Index(value = ["name"], unique = true)])
data class Rocket(
    @PrimaryKey
    val rocketid: Long? = 0,
    val name: String? = null,
    val country: String? = null,
    //val engines: Engine? = null,
    val description: String? = null
) : Parcelable