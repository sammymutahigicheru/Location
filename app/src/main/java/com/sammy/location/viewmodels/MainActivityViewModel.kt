package com.sammy.location.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sammy.domain.models.LocationBodyRequest
import com.sammy.domain.usecases.LocationsBaseUseCase
import com.sammy.location.commons.ExceptionHandler
import com.sammy.location.mappers.toPresentation
import com.sammy.location.models.LocationPresentation
import com.sammy.location.models.states.Error
import com.sammy.location.models.states.MainLocationViewState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect

class MainActivityViewModel(private val locationsBaseUseCase: LocationsBaseUseCase) :
    BaseViewModel() {
    private var getLocationJob:Job? = null
    val locationViewState: LiveData<MainLocationViewState>
        get() = _locationViewState

    private var _locationViewState = MutableLiveData<MainLocationViewState>()

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        val message = exception.message.toString()
        onGetLocationError(message)
    }

    private fun onGetLocationError(message: String) {
        _locationViewState.value = _locationViewState.value?.copy(isLoading = false,error = Error(message))
    }

    private fun onGetLocationLoading(){
        _locationViewState.value = _locationViewState.value?.copy(isLoading = true)
    }

    private fun onCompleteGetLocation(location:List<LocationPresentation>){
        _locationViewState.value = _locationViewState.value?.copy(isLoading = false,locationResults = location)
    }

    init {
        _locationViewState.value =
            MainLocationViewState(
                isLoading = false,
                error = null,
                locationResults = null
            )
    }

    override fun onCleared() {
        super.onCleared()
        getLocationJob?.cancel()
    }
    fun executeGetLocation(locationBodyRequest: LocationBodyRequest){
        getLocationJob?.cancel()
        getLocationJob = launchCoroutine {
            delay(500)
            onGetLocationLoading()
            locationsBaseUseCase(locationBodyRequest).collect {
                val locations = it.map { location -> location.toPresentation()  }
                onCompleteGetLocation(locations)
            }
        }
    }
}