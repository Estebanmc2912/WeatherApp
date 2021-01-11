package com.bringglobal.weatherapp.ui.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bringglobal.weatherapp.R
import com.bringglobal.weatherapp.ui.main.home.adapter.RecyclerViewHomeAdapter
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {


    private var layoutManager : RecyclerView.LayoutManager?=null
    private var adapter : RecyclerView.Adapter<RecyclerView.ViewHolder> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         var vista : View  =  inflater.inflate(R.layout.fragment_home, container, false)


        return vista
    }



    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        rv_home.apply {

            layoutManager = LinearLayoutManager(activity)
            rv_home.layoutManager = layoutManager


             val itemLocations = arrayOf(
                "Bogotá",
                "Soacha",
                "Cali",
                "Medellin",
                "Santander",
                "Bucaramanga"
            )

            adapter = RecyclerViewHomeAdapter(itemLocations, context)
            rv_home.adapter = adapter
        }
    }



}