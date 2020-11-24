package com.sammy.data_remote.models

data class LocationBodyRequest(
    val miatConfig:MiataruConfig,
    val miatGetLocation:MiataruGetLocation
)

data class MiataruConfig(
    val miataruConfig:RequestMiataruDeviceID
)
data class RequestMiataruDeviceID(
    val requestMiataruDeviceID:String
)
data class MiataruGetLocation(
    val device:List<Device>
)
data class Device(
    val deviceString:String
)