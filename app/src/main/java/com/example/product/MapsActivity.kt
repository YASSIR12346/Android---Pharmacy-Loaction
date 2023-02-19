package com.example.product

import android.accessibilityservice.GestureDescription
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.product.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.DirectionsApi
import com.google.maps.GeoApiContext

class MapsActivity : FragmentActivity(), OnMapReadyCallback {
    private var mMap: GoogleMap? = null
    private var binding: ActivityMapsBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val market = LatLng(intent.getDoubleExtra("latitude", 0.0), intent.getDoubleExtra("longitude", 0.0))
        val current=LatLng(DataConfig.location!!.latitude,DataConfig.location!!.longitude)
        googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        mMap!!.addMarker(MarkerOptions().position(market).title(intent.getStringExtra("name")).icon(BitmapDescriptorFactory
            .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap!!.addMarker(MarkerOptions().position(current).title("Position"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(market))
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(13f))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(market))





    }
}