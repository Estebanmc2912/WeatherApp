package com.bringglobal.weatherapp.ui.main.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bringglobal.weatherapp.R
import com.bringglobal.weatherapp.ui.main.common.ClickEventHandler
import kotlinx.android.synthetic.main.card_fragment_home.view.*


class RecyclerViewHomeAdapter (private val itemLocations: ArrayList<String>,
                               private val context: Context) : RecyclerView.Adapter<RecyclerViewHomeAdapter.ViewHolder>() {

    private val clickHandler : ClickEventHandler = context as ClickEventHandler

    lateinit var vieww : View

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var location : TextView

        init {
            location = itemView.tv_card_home_location
            itemView.tv_card_home_location.setOnClickListener {
                clickHandler.viewFollowCity(it, location.text.toString())
            }
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewHomeAdapter.ViewHolder {
        vieww = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_fragment_home, parent, false)
        return ViewHolder(vieww)
    }

    override fun onBindViewHolder(holder: RecyclerViewHomeAdapter.ViewHolder, position: Int) {
       holder.location.text = itemLocations[position]

    }



    override fun getItemCount(): Int {
        return itemLocations.size
    }



}