package com.sammy.data_remote.mappers

import com.sammy.data_remote.models.LocationResponse
import com.sammy.data_remote.models.MiataruLocation

internal fun LocationResponse.toDomain(): MiataruLocation {
    return MiataruLocation(
        this.location.iterator().next().device,
        this.location.iterator().next().timestamp,
        this.location.iterator().next().longitude,
        this.location.iterator().next().latitude,
        this.location.iterator().next().horizontalAccuracy
    )
}