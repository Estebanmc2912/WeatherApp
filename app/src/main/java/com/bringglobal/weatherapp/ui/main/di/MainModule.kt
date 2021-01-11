package com.bringglobal.weatherapp.ui.main.di

import com.bringglobal.weatherapp.app.di.ActivityScope
import com.bringglobal.weatherapp.ui.main.MainActivity
import com.bringglobal.weatherapp.ui.main.MainContract
import com.bringglobal.weatherapp.ui.main.MainPresenter
import com.bringglobal.weatherapp.ui.main.MainRouter
import com.bringglobal.weatherapp.ui.splash.SplashContract
import com.bringglobal.weatherapp.ui.splash.SplashPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @ActivityScope
    fun router(activity : MainActivity) : MainContract.Router = MainRouter(activity)


    @Provides
    @ActivityScope
    fun presenter(router: MainContract.Router) = MainPresenter(router)

}




