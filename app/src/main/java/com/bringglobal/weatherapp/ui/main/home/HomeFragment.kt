package com.bringglobal.weatherapp.ui.main.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bringglobal.weatherapp.R
import com.bringglobal.weatherapp.ui.main.common.ClickEventHandler
import com.bringglobal.weatherapp.ui.main.home.adapter.RecyclerViewHomeAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment() , SearchView.OnQueryTextListener {

    private var clickHandler : ClickEventHandler ? = null

    private var layoutManager : RecyclerView.LayoutManager?=null
    private var adapter : RecyclerView.Adapter<RecyclerView.ViewHolder> ?= null
    private val mContext: Context? = null
    val itemLocations = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        clickHandler =  context as ClickEventHandler
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         var vista : View  =  inflater.inflate(R.layout.fragment_home, container, false)

        vista.fab_fragment_home.setOnClickListener{
            clickHandler?.viewFollowMap()
        }

        return vista
    }




    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        clickHandler =  context as ClickEventHandler
        rv_home.apply {

            layoutManager = LinearLayoutManager(activity)
            rv_home.layoutManager = layoutManager

            itemLocations.add("Bogotá")
            itemLocations.add( "London")
            itemLocations.add( "NewYork")
            itemLocations.add( "Tokyo")
            itemLocations.add( "Paris")
            itemLocations.add( "Chicago")
            adapter = RecyclerViewHomeAdapter(itemLocations, context)
            rv_home.adapter = adapter
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        newText?.toLowerCase(Locale.ENGLISH)
        return false
    }




}