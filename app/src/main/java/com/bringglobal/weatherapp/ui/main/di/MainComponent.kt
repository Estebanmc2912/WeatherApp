package com.bringglobal.weatherapp.ui.main.di

import com.bringglobal.weatherapp.app.di.ActivityScope
import com.bringglobal.weatherapp.app.di.AppComponent
import com.bringglobal.weatherapp.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [MainModule::class], dependencies = [AppComponent::class])
public interface MainComponent {

    fun inject(target: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: MainActivity): Builder

        fun appComponent(component:AppComponent): Builder

        fun plus(module: MainModule): Builder

        fun build(): MainComponent
    }

}