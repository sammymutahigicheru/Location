package com.sammy.location

import android.app.Application
import com.facebook.stetho.Stetho
import com.sammy.location.di.networkModule
import com.sammy.location.di.remoteDataSourceModule
import com.sammy.location.di.useCaseModule
import com.sammy.location.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LocationApp : Application(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)

        startKoin {
            androidContext(this@LocationApp)
            modules(
                networkModule,
                viewModelModule,
               // localDataSourceModule,
                remoteDataSourceModule,
                useCaseModule
            )
        }
    }
}