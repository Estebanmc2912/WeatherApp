package com.bringglobal.weatherapp.ui.splash.di

import android.content.Intent
import com.bringglobal.weatherapp.ui.MainActivity
import com.bringglobal.weatherapp.ui.splash.SplashActivity
import com.bringglobal.weatherapp.ui.splash.SplashContract

class SplashRouter(private val activity: SplashActivity) : SplashContract.Router {

    override fun openMain() {
        //MainActivity.launch(activity)
        //activity.startActivity(Intent(activity,MainActivity::class.java))

        //MainActivity.launch(activity)
        //activity.finish()
    }
}