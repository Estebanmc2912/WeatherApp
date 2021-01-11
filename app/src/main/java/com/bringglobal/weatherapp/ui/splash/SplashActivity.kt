package com.bringglobal.weatherapp.ui.splash

import android.os.Bundle
import android.os.Handler
import com.bringglobal.weatherapp.R
import com.bringglobal.weatherapp.app.App
import com.bringglobal.weatherapp.ui.common.BaseActivity
import com.bringglobal.weatherapp.ui.splash.di.DaggerSplashComponent
import com.bringglobal.weatherapp.ui.splash.di.SplashComponent
import com.bringglobal.weatherapp.ui.splash.di.SplashModule
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_splashscreen.*

class SplashActivity : BaseActivity<SplashContract.View, SplashPresenter>(), SplashContract.View {

    @Inject
    override lateinit var presenter: SplashPresenter

    val component: SplashComponent by lazy {
        DaggerSplashComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(SplashModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        component.inject(this)
        presenter.bindView(this)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun packageName():String{return packageName}


}