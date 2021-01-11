package com.bringglobal.weatherapp.ui.main.home.common

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bringglobal.weatherapp.R
import com.bringglobal.weatherapp.ui.common.BaseActivity
import com.bringglobal.weatherapp.ui.main.common.ClickEventHandler
import com.bringglobal.weatherapp.ui.main.home.HomeFragment
import kotlinx.android.synthetic.main.card_fragment_home.view.*


class RecyclerViewAdapter ( private val itemLocations: Array<String>,
                            private val context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    private val clickHandler : ClickEventHandler = context as ClickEventHandler

    lateinit var cardView : RecyclerView
    lateinit var vista : View
    lateinit var actividad : Activity


    private val fragmentManager : FragmentManager ?= null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var location : TextView

        init {
            location = itemView.tv_card_home_location
            itemView.tv_card_home_location.setOnClickListener {
                clickHandler.viewFollow(it, location.text.toString())
            }
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolder {
        vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_fragment_home, parent, false)



        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
       holder.location.text = itemLocations[position]

    }



    override fun getItemCount(): Int {
        return itemLocations.size
    }



}