package com.bringglobal.weatherapp.ui.main.map

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bringglobal.weatherapp.R
import com.bringglobal.weatherapp.ui.main.map.common.DialogMapFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_map.*
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapFragment : Fragment() , OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnInfoWindowClickListener {


    private lateinit var googleMap: GoogleMap
    private lateinit var marker : Marker

    private  var latitude : String = ""
    private  var longitude : String = ""
    private  var cityname : String = ""
    private  var countryname : String = ""

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mp_fragment_map.onCreate(savedInstanceState)
        mp_fragment_map.onResume()
        mp_fragment_map.getMapAsync(this)

    }

    override fun onMapReady(map: GoogleMap?) {
        map?.let {
            googleMap = it
            var latlng : LatLng = LatLng(40.73, -73.935)

            marker = googleMap.addMarker(
                MarkerOptions()
                    .position(latlng)
                    .draggable(true)
                    .title("Current Selection")
                    .snippet("Lat:" + " Lng: ")
            )

            googleMap.setOnMapClickListener(this)
            googleMap.setOnInfoWindowClickListener(this)
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latlng))

        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v : View = inflater.inflate(R.layout.fragment_map, container, false)

        return v
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MapFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

    override fun onMapClick(p0: LatLng) {
         if(marker!=null){
            marker.remove()
        }
        latitude = p0.latitude.toString()
        longitude = p0.longitude.toString()

        var geocoder = Geocoder(context, Locale.getDefault())
        var addresses: List<Address> = geocoder.getFromLocation(p0.latitude, p0.longitude, 1)

        cityname = addresses[0].adminArea

        countryname = addresses[0].countryName

        marker = googleMap.addMarker(
            MarkerOptions()
                .position(p0)
                .draggable(true)
                .title("Selection")
                .snippet("City: " + cityname +
                        "\nCountry: " + countryname)
        )

    }

    override fun onInfoWindowClick(p0: Marker?) {
        var dialogMapFragment : DialogMapFragment = DialogMapFragment(latitude,longitude,cityname,countryname)
        dialogMapFragment.show( (context as FragmentActivity).supportFragmentManager, "Map Dialog" )

    }

    /*override fun onMarkerDragStart(p0: Marker?) {

    }

    override fun onMarkerDrag(p0: Marker?) {

    }

    override fun onMarkerDragEnd(p0: Marker?) {

        Toast.makeText(context, "Lat: " + marker.position.latitude + "\nLng: " + marker.position.longitude, Toast.LENGTH_SHORT).show()

    }*/


}