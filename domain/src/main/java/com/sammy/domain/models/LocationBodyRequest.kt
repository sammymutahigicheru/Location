package com.sammy.domain.models

import com.squareup.moshi.JsonClass
import com.sun.xml.internal.ws.commons.xmlutil.Converter

data class LocationBodyRequest(
    val MiataruConfig: MiataruConfig,
    val MiataruGetLocation: List<MiataruGetLocation>
)