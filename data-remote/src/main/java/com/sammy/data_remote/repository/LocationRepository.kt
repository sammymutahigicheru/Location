package com.sammy.data_remote.repository

import com.sammy.data_remote.api.LocationApiService
import com.sammy.data_remote.models.MiataruLocation
import com.sammy.data_remote.mappers.toDomain
import com.sammy.domain.models.Location
import com.sammy.domain.models.LocationBodyRequest
import com.sammy.domain.repository.ILocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import sun.rmi.runtime.Log
import java.util.*
import kotlin.collections.HashMap

class LocationRepository(
    private val locationApiService: LocationApiService
) : ILocationRepository {
    override suspend fun getCurrentLocation(locationBodyRequest: LocationBodyRequest): Flow<List<Location>> =
        flow {
            val locationResponse = locationApiService.getCurrentLocation(locationBodyRequest)
            val locations = mutableListOf<Location>()
            for (location in locationResponse.MiataruLocation) {
                locations.add(location.toDomain())
            }
            emit(locations)
        }


}