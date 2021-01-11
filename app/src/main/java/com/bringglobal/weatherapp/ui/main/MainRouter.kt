package com.bringglobal.weatherapp.ui.main

import android.content.Intent

class MainRouter (private val activity: MainActivity) : MainContract.Router {

    override fun openMain() {
        activity.startActivity(Intent(activity, MainActivity::class.java))
        activity.finish()

        //MainActivity.launch(activity)
        //MainActivity.launch(activity)
        //activity.finish()
    }
}