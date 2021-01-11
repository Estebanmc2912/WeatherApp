package com.bringglobal.weatherapp.ui.main

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bringglobal.weatherapp.R
import com.bringglobal.weatherapp.app.App
import com.bringglobal.weatherapp.ui.common.BaseActivity
import com.bringglobal.weatherapp.ui.main.city.CityFragment
import com.bringglobal.weatherapp.ui.main.common.ClickEventHandler
import com.bringglobal.weatherapp.ui.main.di.DaggerMainComponent
import com.bringglobal.weatherapp.ui.main.di.MainComponent
import com.bringglobal.weatherapp.ui.main.di.MainModule
import com.bringglobal.weatherapp.ui.main.home.HomeFragment
import com.bringglobal.weatherapp.ui.main.map.MapFragment
import com.bringglobal.weatherapp.ui.main.settings.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

import javax.inject.Inject
import kotlin.math.log

class MainActivity : BaseActivity<MainContract.View, MainPresenter>(), MainContract.View , ClickEventHandler {

    @Inject
    override lateinit var presenter: MainPresenter
    val homeFragment = HomeFragment()
    val mapFragment = MapFragment()
    val cityFragment = CityFragment()
    val settingsFragment = SettingsFragment()


    val component: MainComponent by lazy {
        DaggerMainComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(MainModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component.inject(this)
        presenter.bindView(this)
        presenter.onViewCreated()



        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item_navigationbar_home -> makeCurrentFragment(homeFragment)
                R.id.item_navigationbar_map -> makeCurrentFragment(mapFragment)
                R.id.item_navigationbar_city -> makeCurrentFragment(cityFragment)
                R.id.item_navigationbar_settings -> makeCurrentFragment(settingsFragment)
            }
            true
        }


    }

    override fun informationandFragment(string : String, int : Int){
        val mapFragment = MapFragment()
        makeCurrentFragment(mapFragment)

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun packageName():String{return packageName}


    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

    private fun makeCurrentFragmentArgument(fragment: Fragment, arg : String) =
        supportFragmentManager.beginTransaction().apply {
            var b = Bundle().apply {
                putString("location",arg)
            }
            fragment.arguments = b
            replace(R.id.fl_wrapper, fragment)
            commit()

        }

    override fun viewFollow(holder: View, enter: String) {
        makeCurrentFragmentArgument(cityFragment, enter)
    }




}