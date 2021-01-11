package com.bringglobal.weatherapp.app.di.connection

object ApiEndpoint {
    var BASEURL = "http://api.openweathermap.org/data/2.5/"
    var ApiKey = "c6e381d8c7ff98f0fee43775817cf6ad"
    var CurrentWeather = "weather?"
    var ListWeather = "forecast?"
    var Daily = "forecast/daily?"
    var UnitsAppid = "&units=metric&appid={YOUR APP ID}"
    var UnitsAppidDaily = "&units=metric&cnt=15&appid={YOUR APP ID}"
}