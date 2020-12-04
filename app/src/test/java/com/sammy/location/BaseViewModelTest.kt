package com.sammy.location

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sammy.location.utils.CoroutineTestRule
import com.sammy.location.utils.UiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.koin.test.AutoCloseKoinTest

abstract class BaseViewModelTest:AutoCloseKoinTest() {
    /**
     * Swaps the background executor used by the Architecture Components with a different one which
     * executes each task synchronously.
     **/
    @get:Rule
    open val instantExecutorRule = InstantTaskExecutorRule()

    /**
     * A test rule to allow testing coroutines that use the main dispatcher
     */
    @ExperimentalCoroutinesApi
    @get:Rule
    open val coroutineTestRule = CoroutineTestRule()

    abstract fun prepareViewModel(uiState: UiState)
}