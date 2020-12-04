package com.sammy.location.viewmodels

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.sammy.location.BaseViewModelTest
import com.sammy.location.fakes.FakeGetLocationUseCase
import com.sammy.location.utils.Data
import com.sammy.location.utils.UiState
import com.sammy.location.utils.observeOnce
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
@ExperimentalCoroutinesApi
class MainActivityViewModelTest:BaseViewModelTest() {
    lateinit var viewModel:MainActivityViewModel
    @Test
    fun `given a body request parameter when search executed then return success state`() {
        coroutineTestRule.dispatcher.runBlockingTest {
            prepareViewModel(UiState.SUCCESS)

            viewModel.executeGetLocation(Data.request)

            advanceTimeBy(600)

            viewModel.locationViewState.observeOnce{ state ->
                Truth.assertThat(state.error).isNull()
                Truth.assertThat(state.locationResults).isNotEmpty()
            }
        }
    }
    override fun prepareViewModel(uiState: UiState) {
        val locationsBaseUseCase = FakeGetLocationUseCase(uiState)
        viewModel = MainActivityViewModel(locationsBaseUseCase)
    }
}