package com.bringglobal.weatherapp.ui.splashscreen.di

import com.bringglobal.weatherapp.app.di.ActivityScope
import com.bringglobal.weatherapp.app.di.AppComponent
import com.bringglobal.weatherapp.ui.splashscreen.OnBoardingActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [OnBoardingModule::class], dependencies = [AppComponent::class])
interface OnBoardingComponent {

    fun inject(target: OnBoardingActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: OnBoardingActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: OnBoardingModule): Builder

        fun build(): OnBoardingComponent
    }

}