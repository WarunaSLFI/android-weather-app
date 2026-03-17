# Android Weather App

A simple Android weather application built with Jetpack Compose and Retrofit. Displays real-time weather data for Tampere using the OpenWeatherMap API.

## Features

- Current temperature, feels like, humidity, and wind speed
- Weather condition description (e.g., overcast clouds, clear sky)
- Refresh button to reload weather data
- Loading and error state handling
- All UI texts stored in `strings.xml` for localization

## Tech Stack

- **Kotlin** - Programming language
- **Jetpack Compose** - UI framework
- **Retrofit** - HTTP client for REST API calls
- **Gson** - JSON parsing
- **ViewModel** - UI state management
- **Coroutines** - Asynchronous network calls

## Project Structure

```
app/src/main/java/com/example/weatherapp/
├── MainActivity.kt        # Entry point, sets up the screen
├── WeatherScreen.kt       # Compose UI for displaying weather
├── WeatherViewModel.kt    # Manages UI state and API calls
├── WeatherService.kt      # Retrofit configuration and API interface
└── WeatherModels.kt       # Data classes for API response
```

## Setup Instructions

1. Clone the repository:
   ```
   git clone https://github.com/WarunaSLFI/android-weather-app.git
   ```
2. Open the project in **Android Studio**
3. Sync the project with Gradle files
4. Run the app on an emulator or physical device

## API

This app uses the [OpenWeatherMap API](https://openweathermap.org/api) to fetch current weather data.

## Requirements

- Android Studio
- Min SDK: 24 (Android 7.0)
- Target SDK: 36
- Internet connection for fetching weather data
