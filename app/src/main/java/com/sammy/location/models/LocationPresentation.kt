package com.sammy.location.models

data class LocationPresentation(
    val device: String,
    val timestamp: String,
    val longitude: String,
    val latitude: String,
    val horizontalAccuracy: String
)