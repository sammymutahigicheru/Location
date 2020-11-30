package com.sammy.domain.usecases

import com.sammy.domain.models.Location
import com.sammy.domain.models.LocationBodyRequest
import com.sammy.domain.repository.ILocationRepository
import kotlinx.coroutines.flow.Flow

typealias LocationsBaseUseCase = BaseUseCase<LocationBodyRequest, Flow<List<Location>>>

class LocationUseCase (private val locationRepository: ILocationRepository):LocationsBaseUseCase{
    override suspend fun invoke(parameter: LocationBodyRequest): Flow<List<Location>> =
        locationRepository.getCurrentLocation(parameter)

}
