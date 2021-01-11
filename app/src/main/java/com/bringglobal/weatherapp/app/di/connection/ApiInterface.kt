package com.bringglobal.weatherapp.app.di.connection

import com.bringglobal.weatherapp.ui.main.city.entity.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("weather?appid=c6e381d8c7ff98f0fee43775817cf6ad&units=metric")
    fun getWeatherMainData(@Query("q") name: String?): Call<EntityListMain>

    @GET("weather?appid=c6e381d8c7ff98f0fee43775817cf6ad&units=metric")
    fun getWeatherRainData(@Query("q") name: String?): Call<EntityListRain>

    @GET("weather?appid=c6e381d8c7ff98f0fee43775817cf6ad&units=metric")
    fun getWeatherWindData(@Query("q") name: String?): Call<EntityListWind>

}