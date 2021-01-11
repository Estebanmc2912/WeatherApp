package com.bringglobal.weatherapp.app.di.connection

import com.bringglobal.weatherapp.ui.main.city.entity.EntityExample
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("weather?appid=c6e381d8c7ff98f0fee43775817cf6ad&units=metric")
    fun getWeatherData(@Query("q") name: String?): Call<EntityExample>
}