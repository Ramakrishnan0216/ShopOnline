package com.realmatez.shoponline.data

import com.realmatez.shoponline.models.LocationModel
import com.realmatez.shoponline.models.ShopModel

object DummyData {
    fun getShops(): List<ShopModel> {
        val shops = ArrayList<ShopModel>()
        shops.add(
            ShopModel(
                id = 1,
                name = "Shop1",
                location = LocationModel(9.813009, 80.222212)
            )
        )
        shops.add(
            ShopModel(
                id = 2,
                name = "Shop2",
                location = LocationModel(9.813784, 80.219115)
            )
        )
        shops.add(
            ShopModel(
                id = 3,
                name = "Shop3",
                location = LocationModel(9.817109, 80.224683)
            )
        )
        shops.add(
            ShopModel(
                id = 4,
                name = "Shop4",
                location = LocationModel(9.824073, 80.228495)
            )
        )
        return shops
    }
}