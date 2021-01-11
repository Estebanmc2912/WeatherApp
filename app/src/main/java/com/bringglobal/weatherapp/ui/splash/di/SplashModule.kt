package com.bringglobal.weatherapp.ui.splash.di

import com.bringglobal.weatherapp.app.di.ActivityScope
import com.bringglobal.weatherapp.ui.splash.SplashActivity
import com.bringglobal.weatherapp.ui.splash.SplashContract
import com.bringglobal.weatherapp.ui.splash.SplashPresenter
import com.bringglobal.weatherapp.ui.splash.SplashRouter
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

@Provides
@ActivityScope
fun router(activity : SplashActivity) : SplashContract.Router = SplashRouter(activity)

@Provides
@ActivityScope
fun presenter(router: SplashContract.Router) = SplashPresenter(router)

}