package com.realmatez.shoponline.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import com.realmatez.shoponline.models.LocationModel
import com.realmatez.shoponline.models.ShopModel
import com.realmatez.shoponline.ui.home.ShopAdapter
import com.realmatez.shoponline.ui.home.ShopListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor():ViewModel(), ShopListener{
    var shopAdapter:ShopAdapter = ShopAdapter()
    var  selectedShopModel:ShopModel= ShopModel(id = 0,"Sydeney", LocationModel(-34.0, 151.0))
    val goToMapLiveData:MutableLiveData<Boolean> = MutableLiveData(false)
    init {
        shopAdapter.setListener(this)
    }
    override fun onShopClicked(shop: ShopModel) {
        selectedShopModel = shop
        goToMapLiveData.value = true
    }

}