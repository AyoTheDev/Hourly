package com.ayo.data.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "employers", indices = [Index(value = ["id"], unique = true)])
data class EmployerData(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val imageUrl: String?,
    val name: String?
) : Parcelable