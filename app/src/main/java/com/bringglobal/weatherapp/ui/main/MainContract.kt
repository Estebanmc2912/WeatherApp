package com.bringglobal.weatherapp.ui.main

import com.bringglobal.weatherapp.ui.common.BaseView

interface MainContract {
    interface View : BaseView {
        fun packageName():String
        fun  informationandFragment(string : String, int : Int)
    }

    interface Presenter {
        fun bindView(view: View)

        fun unbindView()

        fun onViewCreated()
    }

    interface Router {
        fun openMain()
    }
}