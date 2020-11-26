package com.sammy.location.di

import com.sammy.domain.repository.ILocationRepository
import com.sammy.domain.usecases.LocationUseCase
import com.sammy.domain.usecases.LocationsBaseUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {
   single(named("location")) { provideLocationUseCase(get()) }
}
internal fun provideLocationUseCase(location:ILocationRepository): LocationsBaseUseCase =
    LocationUseCase(location)