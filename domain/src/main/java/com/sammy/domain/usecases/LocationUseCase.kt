package com.sammy.domain.usecases

import com.sammy.domain.models.Location
import com.sammy.domain.models.LocationBodyRequest
import com.sammy.domain.repository.ILocationRepository
import kotlinx.coroutines.flow.Flow

typealias LocationsBaseUseCase = BaseUseCase<HashMap<String,String>, Flow<List<Location>>>

class LocationUseCase (private val locationRepository: ILocationRepository):LocationsBaseUseCase{
    override suspend fun invoke(parameter: HashMap<String,String>): Flow<List<Location>> =
        locationRepository.getCurrentLocation(parameter)

}
