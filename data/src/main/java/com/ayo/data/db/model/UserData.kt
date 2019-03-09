package com.ayo.data.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "users", indices = [Index(value = ["id"], unique = true)])
data class UserData(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String?,
    val email: String?,
    val password: String? //todo do we need this?
) : Parcelable