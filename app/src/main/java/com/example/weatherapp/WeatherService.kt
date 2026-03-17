package com.example.weatherapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String = "2169ceaf5ce83eb829cd26fe9477d08a",
        @Query("units") units: String = "metric"
    ): WeatherResponse
}

object WeatherService {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: WeatherApi = retrofit.create(WeatherApi::class.java)
}
