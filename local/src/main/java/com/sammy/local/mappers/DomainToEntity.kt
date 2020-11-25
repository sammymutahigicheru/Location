package com.sammy.local.mappers

import com.sammy.domain.models.Favourite
import com.sammy.local.models.FavouriteEntity

internal fun Favourite.toEntity():FavouriteEntity =
    FavouriteEntity(
        id = 0,this.latitude,this.longitude
    )