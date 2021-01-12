package com.bringglobal.weatherapp.ui.main.common

import android.content.Context
import android.view.View

interface ClickEventHandler {
    fun viewFollowCity(holder: View, string: String)
    fun viewFollowMap()
    fun viewFollowHome(string: String)
}