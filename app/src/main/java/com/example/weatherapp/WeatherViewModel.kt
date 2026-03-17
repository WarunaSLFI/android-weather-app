package com.example.weatherapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

data class WeatherUiState(
    val isLoading: Boolean = false,
    val weather: WeatherResponse? = null,
    val error: String? = null
)

class WeatherViewModel : ViewModel() {

    var uiState by mutableStateOf(WeatherUiState())
        private set

    private val city = "Tampere"

    init {
        loadWeather()
    }

    fun loadWeather() {
        uiState = uiState.copy(isLoading = true, error = null)

        viewModelScope.launch {
            try {
                val response = WeatherService.api.getWeather(city)
                uiState = uiState.copy(
                    isLoading = false,
                    weather = response,
                    error = null
                )
            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown error"
                )
            }
        }
    }
}
