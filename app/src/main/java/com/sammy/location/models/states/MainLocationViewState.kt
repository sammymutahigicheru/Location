package com.sammy.location.models.states

import com.sammy.location.models.LocationPresentation

internal data class MainLocationViewState(
    val isLoading: Boolean,
    val error: Error?,
    val searchResults: List<LocationPresentation>?
)