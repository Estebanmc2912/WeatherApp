package com.bringglobal.weatherapp.ui.main.city

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bringglobal.weatherapp.R
import com.bringglobal.weatherapp.app.di.connection.ApiClient
import com.bringglobal.weatherapp.app.di.connection.ApiInterface
import com.bringglobal.weatherapp.ui.main.city.entity.EntityExample
import kotlinx.android.synthetic.main.fragment_city.*
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
    // TODO: Rename and change types of parameters
    private var param1: String? = null



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
        val call: Call<EntityExample> = apiInterface.getWeatherData(name)
        call.enqueue(object : Callback<EntityExample> {
            override fun onResponse(call: Call<EntityExample>, response: Response<EntityExample>) {
                tv_city_temp.text = response.body()?.main?.temp
                tv_city_location.text = name
                tv_city_sunny.setText("Feels Like" + " " + response.body()?.main?.feels_like)
                //humidityText.setText("Humidity" + " " + response.body()?.main?.humidity)
            }

            override fun onFailure(call: Call<EntityExample>, t: Throwable) {}
        })
    }

}