package com.sammy.location.fakes

import com.sammy.location.utils.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseTestUseCase<out T, in P>(private val uiState: UiState) {

    fun execute(params: P): Flow<T> = flow {
        when (uiState) {
            UiState.SUCCESS -> emit(getValue(params))
            UiState.ERROR -> throw Exception("Something went wrong")
        }
    }

    abstract fun getValue(params: P): T

}