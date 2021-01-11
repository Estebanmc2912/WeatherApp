package com.bringglobal.weatherapp.ui.main

import android.os.Handler
import com.bringglobal.weatherapp.ui.common.BasePresenter
import com.bringglobal.weatherapp.ui.splash.SplashContract

class MainPresenter (private val router: MainContract.Router) : BasePresenter<MainContract.View>(), MainContract.Presenter {

    companion object {

    }

    override var view: MainContract.View? = null

    override fun bindView(view: MainContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null

    }

    override fun onViewCreated() {
        // when the view is created

    }


}