package com.sammy.data_remote.api

import com.sammy.data_remote.models.LocationResponse
import com.sammy.domain.models.LocationBodyRequest
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LocationApiService {
    @POST("v1/GetLocation")
    suspend fun getCurrentLocation(@Body locationBodyRequest: LocationBodyRequest):LocationResponse
}