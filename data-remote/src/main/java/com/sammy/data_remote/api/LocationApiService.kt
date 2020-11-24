package com.sammy.data_remote.api

import com.sammy.data_remote.models.LocationBodyRequest
import com.sammy.data_remote.models.LocationResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LocationApiService {
    @POST("v1/GetLocation")
    suspend fun getCurrentLocation(@Body locationBodyRequest:LocationBodyRequest):LocationResponse
}