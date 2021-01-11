package com.bringglobal.weatherapp.ui.main.city.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bringglobal.weatherapp.R
import kotlinx.android.synthetic.main.card_fragment_city.view.*
import kotlinx.android.synthetic.main.card_fragment_home.view.*


class RecyclerViewCityAdapter (private val itemNames: Array<String>,
                               private val context: Context) : RecyclerView.Adapter<RecyclerViewCityAdapter.ViewHolder>() {


    lateinit var vista : View


    private val fragmentManager : FragmentManager ?= null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var day : TextView

        init {
            day = itemView.tv_card_city_day
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewCityAdapter.ViewHolder {
        vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_fragment_city, parent, false)

        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: RecyclerViewCityAdapter.ViewHolder, position: Int) {
        holder.day.text = itemNames[position]
    }



    override fun getItemCount(): Int {
        return itemNames.size
    }



}