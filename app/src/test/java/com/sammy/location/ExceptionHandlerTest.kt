package com.sammy.location

import com.google.common.truth.Truth
import com.sammy.location.commons.ExceptionHandler
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.net.UnknownHostException

@RunWith(JUnit4::class)
class ExceptionHandlerTest {
    @Test
    fun `given an exception when is instance of UnknownHostException then get No Internet Connection string `() {
        val message = ExceptionHandler.parse(UnknownHostException())
        Truth.assertThat(message).isEqualTo(R.string.error_check_internet_connection)
    }
}