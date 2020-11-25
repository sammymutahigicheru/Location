package com.sammy.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavouriteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val longitude: String,
    val latitude: String
)