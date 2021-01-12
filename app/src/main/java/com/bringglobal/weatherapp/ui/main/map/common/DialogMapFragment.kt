package com.bringglobal.weatherapp.ui.main.map.common

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.bringglobal.weatherapp.R
import com.bringglobal.weatherapp.ui.main.common.ClickEventHandler
import kotlinx.android.synthetic.main.fragment_dialog_map.view.*
import java.lang.RuntimeException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DialogMapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DialogMapFragment (
    var latitude : String,
    var longitude: String,
    var cityname: String,
    var countryname: String) : DialogFragment(){

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var clickHandler : ClickEventHandler? = null
    private var btn_accept : Button ?= null
    private var btn_decline : Button ?= null

    var vieww : View ? = null

    private var activityy : Activity ?=null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (context is Activity){
            activityy = context as Activity
            clickHandler = activityy as ClickEventHandler
        }else{
            throw RuntimeException(context.toString() + " must implement ClickHandler")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return createDialog()
    }



    fun createDialog() : AlertDialog{
        var builder : AlertDialog.Builder = AlertDialog.Builder(activity)
        var inflater : LayoutInflater = activity!!.layoutInflater
        var v : View = inflater.inflate(R.layout.fragment_dialog_map, null)
        builder.setView(v)

        v.tv_dialog_map_txt_cityname.text = cityname
        v.tv_dialog_map_txt_countryname.text = countryname
        v.tv_dialog_map_txt_latitude.text = latitude
        v.tv_dialog_map_txt_longitude.text = longitude

        btn_accept = v.bnt_dialog_map_accept
        btn_decline = v.bnt_dialog_map_decline

        btnEvents()

        return builder.create()

    }

    private fun btnEvents() {
        btn_accept?.setOnClickListener {
            Toast.makeText(context, "accept", Toast.LENGTH_SHORT).show()
            dismiss()
            clickHandler?.viewFollowHome(cityname)
        }
        btn_decline?.setOnClickListener {
            Toast.makeText(context, "decline", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }

}