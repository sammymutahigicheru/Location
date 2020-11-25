package com.sammy.local.dao

import androidx.room.*
import com.sammy.domain.models.Favourite
import com.sammy.domain.models.Result
import com.sammy.local.mappers.toEntity
import com.sammy.local.models.FavouriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favorite:FavouriteEntity):Long
    @Transaction
    suspend fun insert(favorite:Favourite):Result{
        insert(favorite.toEntity())
        return Result.SUCCESS
    }
    @Query("SELECT * FROM favorites")
    suspend fun getAll(): Flow<List<Favourite>>
}