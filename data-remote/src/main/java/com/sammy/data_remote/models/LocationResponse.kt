package com.sammy.data_remote.models

import com.squareup.moshi.Json

data class LocationResponse(
    @field:Json(name="MiataruLocation")
    val location:List<MiataruLocation>
)
data class MiataruLocation(
    @field:Json(name="Device")
    val device:String,
    @field:Json(name="Timestamp")
    val timestamp:String,
    @field:Json(name="Longitude")
    val longitude:String,
    @field:Json(name="Latitude")
    val latitude:String,
    @field:Json(name="HorizontalAccuracy")
    val horizontalAccuracy:String
)