package com.bringglobal.weatherapp.ui.main.city.entity

import com.google.gson.annotations.SerializedName

data class EntityMain (@SerializedName("temp") var temp : String,
                       @SerializedName("humidity") var humidity : String ,
                       @SerializedName("feels_like") var feels_like : String)