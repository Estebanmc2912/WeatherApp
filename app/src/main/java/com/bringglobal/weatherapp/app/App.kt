package com.bringglobal.weatherapp.app

import android.app.Application
import com.bringglobal.weatherapp.app.di.AppComponent
import com.bringglobal.weatherapp.app.di.AppModule
import com.bringglobal.weatherapp.app.di.DaggerAppComponent

class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .plus(AppModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }
}