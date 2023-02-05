package com.damask.weatherapp.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIconDefaults.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.damask.weatherapp.domain.weather.WeatherData
import okhttp3.internal.format
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HourlyWeatherDisplay(
    modifier: Modifier = Modifier,
    weatherData: WeatherData,
    textColor: Color = Color.White
) {

    val formattedTime = remember(weatherData) {
        weatherData.time.format(
            DateTimeFormatter.ofPattern("HH:mm")
        )
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = formattedTime,
            color = Color.LightGray
        )
        Image(
            modifier = Modifier.width(40.dp),
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = "Weather Hour",
        )

        Text(
            text = "${weatherData.temperatureCelsius}°C",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}