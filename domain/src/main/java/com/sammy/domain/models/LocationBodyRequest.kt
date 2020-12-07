package com.sammy.domain.models

data class LocationBodyRequest(
    val MiataruConfig: MiataruConfig,
    val MiataruGetLocation: List<MiataruGetLocation>
)