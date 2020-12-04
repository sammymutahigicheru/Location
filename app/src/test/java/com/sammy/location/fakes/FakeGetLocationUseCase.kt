package com.sammy.location.fakes

import com.sammy.domain.models.Location
import com.sammy.domain.models.LocationBodyRequest
import com.sammy.domain.usecases.LocationsBaseUseCase
import com.sammy.location.utils.Data
import com.sammy.location.utils.UiState
import kotlinx.coroutines.flow.Flow

class FakeGetLocationUseCase(
    uiState: UiState
) : BaseTestUseCase<List<Location>, LocationBodyRequest>(uiState), LocationsBaseUseCase {

    override suspend fun invoke(params: LocationBodyRequest): Flow<List<Location>> = execute(params)

    override fun getValue(params: LocationBodyRequest): List<Location> {
        return if (params.equals(params)) Data.response else emptyList()
    }

}