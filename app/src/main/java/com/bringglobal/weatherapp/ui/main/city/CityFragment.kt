package com.bringglobal.weatherapp.ui.main.city

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bringglobal.weatherapp.R
import com.bringglobal.weatherapp.app.di.connection.ApiClient
import com.bringglobal.weatherapp.app.di.connection.ApiInterface
import com.bringglobal.weatherapp.ui.main.city.adapter.RecyclerViewCityAdapter
import com.bringglobal.weatherapp.ui.main.city.entity.EntityListMain
import com.bringglobal.weatherapp.ui.main.city.entity.EntityListRain
import com.bringglobal.weatherapp.ui.main.city.entity.EntityListWind
import kotlinx.android.synthetic.main.fragment_city.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "location"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class CityFragment : Fragment() {

    private var param1: String? = null
    private var layoutManager : RecyclerView.LayoutManager?=null
    private var adapter : RecyclerView.Adapter<RecyclerView.ViewHolder> ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            getWeatherData(param1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city, container, false)
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getString(ARG_PARAM1)?.let {
            getWeatherData(it)
        }
    }

    private fun getWeatherData(name: String?) {
        val apiInterface: ApiInterface = ApiClient().getClient().create(ApiInterface::class.java)
        val apiInterface2: ApiInterface = ApiClient().getClient().create(ApiInterface::class.java)
        val apiInterface3: ApiInterface = ApiClient().getClient().create(ApiInterface::class.java)
        val call: Call<EntityListMain> = apiInterface.getWeatherMainData(name)
        call.enqueue(object : Callback<EntityListMain> {
            override fun onResponse(call: Call<EntityListMain>, response: Response<EntityListMain>) {
                tv_city_temp.text = response.body()?.main?.temp
                tv_city_location.text = name
                tv_city_sunny.text = "Feels Like" + " " + response.body()?.main?.feels_like
                tv_city_text_humidity.text = response.body()?.main?.humidity
            }

            override fun onFailure(call: Call<EntityListMain>, t: Throwable) {}
        })

        val call2: Call<EntityListRain> = apiInterface2.getWeatherRainData(name)
        call2.enqueue(object : Callback<EntityListRain> {
            override fun onResponse(call: Call<EntityListRain>, response: Response<EntityListRain>) {
                var rta = response.body()?.rain?.rainvolume
                if (rta.isNullOrBlank()){
                    tv_city_text_rainchances.text = "0%"
                }else{
                    tv_city_text_rainchances.text = rta + '%'
                }

            }

            override fun onFailure(call: Call<EntityListRain>, t: Throwable) {}
        })

        val call3: Call<EntityListWind> = apiInterface3.getWeatherWindData(name)
        call3.enqueue(object : Callback<EntityListWind> {
            override fun onResponse(call: Call<EntityListWind>, response: Response<EntityListWind>) {
                var rta = response.body()?.wind?.speed
                if (rta.isNullOrBlank()){
                    tv_city_text_wind.text = "0%"
                }else{
                    tv_city_text_wind.text = rta + '%'
                }


            }

            override fun onFailure(call: Call<EntityListWind>, t: Throwable) {}
        })


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_city.apply {

            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            rv_city.layoutManager = layoutManager

            val itemLocations = arrayOf(
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thusday",
                "Friday",
            )

            adapter = RecyclerViewCityAdapter(itemLocations, context)
            rv_city.adapter = adapter
        }

    }

    private fun getWeatherData5days(){

    }

}