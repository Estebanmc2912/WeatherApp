package com.bringglobal.weatherapp.ui.splash

import android.os.Handler
import com.bringglobal.weatherapp.R
import com.bringglobal.weatherapp.ui.common.BasePresenter
import com.bringglobal.weatherapp.ui.splash.SplashContract

class SplashPresenter(private val router: SplashContract.Router) : BasePresenter<SplashContract.View>(), SplashContract.Presenter {

    companion object {
        private const val SPLASH_DISPLAY_TIME : Long = 4000
    }

    override var view: SplashContract.View? = null

    override fun bindView(view: SplashContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onViewCreated() {

        Handler().postDelayed({
            router.openMain()
        }, SPLASH_DISPLAY_TIME)

    }


}