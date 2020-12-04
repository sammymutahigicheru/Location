package com.sammy.`data-remote`.helpers

import com.sammy.`data-remote`.helpers.Constants.LOCATION_URL
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

/**
 * Handles Requests from mock web server
 */
class LocationRequestDispatcher:Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path){
            LOCATION_URL ->{
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJson("json/location_search.json"))
            }
            else -> throw IllegalArgumentException("Unknown Request Path ${request.path.toString()}")
        }
    }
}