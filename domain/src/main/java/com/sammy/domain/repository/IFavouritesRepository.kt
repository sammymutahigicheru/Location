package com.sammy.domain.repository

import com.sammy.domain.models.Favourite
import com.sammy.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface IFavouritesRepository {
    suspend fun getAllFavoritePlaces(): Flow<List<Favourite>>
    suspend fun insertFavorite(favourite: Favourite):Flow<Result>
}