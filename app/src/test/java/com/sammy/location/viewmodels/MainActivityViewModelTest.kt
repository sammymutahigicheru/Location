package com.sammy.location.viewmodels

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sammy.location.BaseViewModelTest
import com.sammy.location.utils.UiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
@ExperimentalCoroutinesApi
class MainActivityViewModelTest:BaseViewModelTest() {
    override fun prepareViewModel(uiState: UiState) {

    }
}