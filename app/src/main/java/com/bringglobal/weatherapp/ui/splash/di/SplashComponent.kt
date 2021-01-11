package com.bringglobal.weatherapp.ui.splash.di

import com.bringglobal.weatherapp.app.di.ActivityScope
import com.bringglobal.weatherapp.app.di.AppComponent
import com.bringglobal.weatherapp.ui.splash.SplashActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [SplashModule::class], dependencies = [AppComponent::class])
interface SplashComponent {

    fun inject(target: SplashActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: SplashActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: SplashModule): Builder

        fun build(): SplashComponent
    }

}