package com.bringglobal.weatherapp.ui.splash

import android.content.Intent
import com.bringglobal.weatherapp.ui.main.MainActivity

class SplashRouter(private val activity: SplashActivity) : SplashContract.Router {

    override fun openMain() {
        activity.startActivity(Intent(activity, MainActivity::class.java))
        activity.finish()

        //MainActivity.launch(activity)
        //MainActivity.launch(activity)
        //activity.finish()
    }
}