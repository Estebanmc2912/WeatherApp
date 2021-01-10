package com.bringglobal.weatherapp.ui.splash.di

import android.os.Handler
import com.bringglobal.weatherapp.ui.splash.SplashContract

class SplashPresenter(private val router: SplashContract.Router) : BasePresenter<SplashContract.View>(), SplashContract.Presenter {

    companion object {
        private const val SPLASH_DISPLAY_TIME = 400
    }

    override var view: SplashContract.View? = null

    override fun bindView(view: SplashContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onViewCreated() {

        val r = object : Runnable {
            override fun run() {
            }
        }

        Handler().postDelayed({
            router.openMain()
        }, 4500)
        view?.showVideo("android.resource://"+ view?.packageName() +"/"+ R.raw.splash, r, 400)

    }


}