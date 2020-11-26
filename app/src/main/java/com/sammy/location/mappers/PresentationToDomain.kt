package com.sammy.location.mappers

import com.sammy.domain.models.Location
import com.sammy.location.models.LocationPresentation

internal fun LocationPresentation.toDomain():Location =
    Location(
        this.device,
        this.timestamp,
        this.longitude,
        this.latitude,
        this.horizontalAccuracy
    )