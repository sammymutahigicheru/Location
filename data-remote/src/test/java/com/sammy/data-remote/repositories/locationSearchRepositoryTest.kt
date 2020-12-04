package com.sammy.`data-remote`.repositories

import com.google.common.truth.Truth
import com.sammy.`data-remote`.BaseTest
import com.sammy.`data-remote`.helpers.Constants.request
import com.sammy.data_remote.api.LocationApiService
import com.sammy.data_remote.repository.LocationRepository
import com.sammy.domain.repository.ILocationRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class locationSearchRepositoryTest:BaseTest() {
    private lateinit var locationRepository: ILocationRepository


    @Before
    fun setup(){
        locationRepository = LocationRepository(locationApiService)
    }
    @Test
    fun `given existing location parameters when executed then return list of location results`(){
        runBlocking {
            val result = locationRepository.getCurrentLocation(request)
            result.collect { Truth.assertThat(it).isNotEmpty() }
        }
    }
}