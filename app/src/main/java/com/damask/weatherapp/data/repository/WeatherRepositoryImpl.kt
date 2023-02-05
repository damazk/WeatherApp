package com.damask.weatherapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.damask.weatherapp.data.mappers.toWeatherInfo
import com.damask.weatherapp.data.remote.WeatherApi
import com.damask.weatherapp.domain.repository.WeatherRepository
import com.damask.weatherapp.domain.util.Resource
import com.damask.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(
                message = e.message ?: "Unknown error occurred!",
            )
        }
    }
}