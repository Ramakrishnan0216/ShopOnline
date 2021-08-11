package com.realmatez.shoponline

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.realmatez.shoponline.base.BaseFragment
import com.realmatez.shoponline.databinding.FragmentMapsBinding
import com.realmatez.shoponline.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MapsFragment : BaseFragment<FragmentMapsBinding>(R.layout.fragment_maps)  {
    private  val  mainViewModel: MainViewModel by activityViewModels()

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        val selectedShopModel = mainViewModel.selectedShopModel
        val latLng = LatLng(selectedShopModel.location.lat, selectedShopModel.location.lng)
        //val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(latLng).title(selectedShopModel.name))
        val cameraPosition = CameraPosition.Builder()
            .target(latLng)
            .zoom(17f).build()
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMapsBinding.bind(view)
        mainViewModel.goToMapLiveData.postValue(false)
       val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}