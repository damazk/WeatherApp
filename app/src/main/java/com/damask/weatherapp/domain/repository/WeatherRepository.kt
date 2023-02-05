package com.damask.weatherapp.domain.repository

import com.damask.weatherapp.domain.util.Resource
import com.damask.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(lat: Double, long: Double) : Resource<WeatherInfo>
}