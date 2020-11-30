package com.sammy.domain.repository

import com.sammy.domain.models.Location
import com.sammy.domain.models.LocationBodyRequest
import kotlinx.coroutines.flow.Flow

interface ILocationRepository {
    suspend fun getCurrentLocation(locationBodyRequest: LocationBodyRequest): Flow<List<Location>>
}