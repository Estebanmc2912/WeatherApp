package com.bringglobal.weatherapp.ui.common

open class BasePresenter <V: BaseView> {
    open var view : V? = null
}