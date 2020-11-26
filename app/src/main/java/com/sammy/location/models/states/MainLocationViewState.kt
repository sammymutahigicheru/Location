package com.sammy.location.models.states

import com.sammy.location.models.LocationPresentation

data class MainLocationViewState(
    val isLoading: Boolean,
    val error: Error?,
    val locationResults: List<LocationPresentation>?
)