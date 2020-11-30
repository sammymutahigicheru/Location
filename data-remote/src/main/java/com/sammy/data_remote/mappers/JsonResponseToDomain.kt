package com.sammy.data_remote.mappers

import com.sammy.data_remote.models.LocationResponse
import com.sammy.data_remote.models.MiataruLocation
import com.sammy.domain.models.Location

internal fun MiataruLocation.toDomain(): Location {
    return Location(
        this.Device,
        this.Timestamp,
        this.Longitude,
        this.Latitude,
        this.HorizontalAccuracy
    )
}