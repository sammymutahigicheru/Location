package com.sammy.local.mappers

import com.sammy.domain.models.Favourite
import com.sammy.local.models.FavouriteEntity

internal fun FavouriteEntity.toDomain():Favourite =
    Favourite(this.latitude,this.longitude)