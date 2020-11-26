package com.sammy.location.di

import com.sammy.data_remote.repository.LocationRepository
import com.sammy.domain.repository.ILocationRepository
import com.sammy.domain.usecases.LocationsBaseUseCase
import dagger.Module
import org.koin.dsl.module

val remoteDataSource = module{
    single<ILocationRepository>{LocationRepository(locationApiService = get())}
}