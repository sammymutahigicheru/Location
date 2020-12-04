package com.sammy.`data-remote`

import com.sammy.`data-remote`.helpers.LocationRequestDispatcher
import com.sammy.data_remote.api.LocationApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

open class BaseTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var loggingInterceptor: HttpLoggingInterceptor
    lateinit var locationApiService: LocationApiService
    @Before
    override fun setUp(){
        this.setUp()
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = LocationRequestDispatcher()
        mockWebServer.start()
        loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        okHttpClient = buildOkhttpClient(loggingInterceptor)

        locationApiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(LocationApiService::class.java)
    }
    private fun buildOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }
    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }
}
