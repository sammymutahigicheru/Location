package com.sammy.location.utils

import com.sammy.domain.models.Location
import com.sammy.domain.models.LocationBodyRequest
import com.sammy.domain.models.MiataruConfig
import com.sammy.domain.models.MiataruGetLocation

object Data {
    val request = LocationBodyRequest(
        MiataruConfig = MiataruConfig("6140c3c0-4a7d-40d2-99ab-39414cac3509"),
        MiataruGetLocation = listOf(MiataruGetLocation("7b8e6e0ee5296db345162dc2ef652c1350761823"))
    )
    val response = listOf(
        Location(
            "7b8e6e0ee5296db345162dc2ef652c1350761823",
            "1441360863",
            "-4.394531",
            "41.079351",
            "50"
        )
    )
}