package com.bringglobal.weatherapp.ui.main.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bringglobal.weatherapp.R
import com.bringglobal.weatherapp.ui.main.common.ClickEventHandler
import com.bringglobal.weatherapp.ui.main.home.adapter.RecyclerViewHomeAdapter
import com.bringglobal.weatherapp.ui.main.home.common.SwipeToDelete
import com.bringglobal.weatherapp.ui.main.home.entity.CardViewEntity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.LinkedHashSet

private const val ARG_PARAM1 = "cityname"

class HomeFragment : Fragment() , SearchView.OnQueryTextListener {

    private var clickHandler : ClickEventHandler ? = null

    private var param1: String? = null

    private var itemLocations : MutableList<CardViewEntity> = ArrayList<CardViewEntity>(LinkedHashSet<CardViewEntity>().toMutableList())
    private var restrictionsame : MutableList<CardViewEntity> = ArrayList<CardViewEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
        if (!param1.isNullOrBlank()){
            var item : CardViewEntity = CardViewEntity( (param1 as String), "20", "sunny")
            itemLocations?.add(item)
            restrictionsame = LinkedHashSet<CardViewEntity>(itemLocations).toMutableList()
        }else{
            var item : CardViewEntity = CardViewEntity( "Bogotá", "20", "sunny")
            itemLocations?.add(item)
            restrictionsame = LinkedHashSet<CardViewEntity>(itemLocations).toMutableList()
        }

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
            adapter = RecyclerViewHomeAdapter(restrictionsame as ArrayList<CardViewEntity>, context)
            rv_home.adapter = adapter

            val item = object : SwipeToDelete(context, 0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    if(itemLocations.size>1){
                        itemLocations.removeAt(viewHolder.adapterPosition)
                        (adapter as RecyclerViewHomeAdapter).deletItem(viewHolder.adapterPosition)
                    }
                }
            }

            val itemTouchHelper = ItemTouchHelper(item)
            itemTouchHelper.attachToRecyclerView(rv_home)

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