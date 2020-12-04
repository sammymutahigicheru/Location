package com.sammy.`data-remote`.helpers

import com.sammy.domain.models.LocationBodyRequest
import com.sammy.domain.models.MiataruConfig
import com.sammy.domain.models.MiataruGetLocation

object Constants {
    const val LOCATION_URL = "/v1/GetLocation"
    val request = LocationBodyRequest(
        MiataruConfig = MiataruConfig("6140c3c0-4a7d-40d2-99ab-39414cac3509"),
        MiataruGetLocation = listOf(MiataruGetLocation("7b8e6e0ee5296db345162dc2ef652c1350761823"))
    )
}