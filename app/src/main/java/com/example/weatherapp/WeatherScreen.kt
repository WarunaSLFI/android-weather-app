package com.example.weatherapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WeatherScreen(modifier: Modifier = Modifier, viewModel: WeatherViewModel = viewModel()) {
    val state = viewModel.uiState

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.screen_title),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        when {
            state.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.size(48.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = stringResource(R.string.loading_text))
            }

            state.error != null -> {
                Text(
                    text = stringResource(R.string.error_text, state.error),
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center
                )
            }

            state.weather != null -> {
                val weather = state.weather

                Text(
                    text = weather.name,
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = weather.weather.firstOrNull()?.description ?: "",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = stringResource(R.string.temperature, weather.main.temp),
                    style = MaterialTheme.typography.displaySmall
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(R.string.feels_like, weather.main.feelsLike),
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row {
                    Text(text = stringResource(R.string.humidity, weather.main.humidity))
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = stringResource(R.string.wind_speed, weather.wind.speed))
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { viewModel.loadWeather() },
            shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
        ) {
            Text(text = stringResource(R.string.refresh_button))
        }
    }
}
