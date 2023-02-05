package com.damask.weatherapp.domain.repository

import com.damask.weatherapp.data.location.DefaultLocationTracker
import com.damask.weatherapp.data.repository.WeatherRepositoryImpl
import com.damask.weatherapp.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}