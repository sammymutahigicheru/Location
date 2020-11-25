package com.sammy.local.repository

import com.sammy.domain.models.Favourite
import com.sammy.domain.models.Result
import com.sammy.domain.repository.IFavouritesRepository
import com.sammy.local.dao.FavoriteDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class FavoritesRepository (private val favoriteDao:FavoriteDao):IFavouritesRepository{
    override suspend fun getAllFavoritePlaces(): Flow<List<Favourite>> = flow {
        val fav = favoriteDao.getAll()
       // emit(fav)
    }

    override suspend fun insertFavorite(favourite: Favourite): Flow<Result> = flow {
        val result = favoriteDao.insert(favourite)
        emit(result)
    }

}