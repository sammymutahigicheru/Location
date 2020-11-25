package com.sammy.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sammy.local.dao.FavoriteDao
import com.sammy.local.models.FavouriteEntity

@Database(
    entities = [FavouriteEntity::class],
    version = 1, exportSchema = false
)
abstract class LocationDatabase : RoomDatabase() {
    abstract fun favouritesDao():FavoriteDao
}