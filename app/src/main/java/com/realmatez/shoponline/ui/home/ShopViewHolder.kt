package com.realmatez.shoponline.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.realmatez.shoponline.databinding.ItemShopBinding
import com.realmatez.shoponline.models.ShopModel

class ShopViewHolder(private val binding : ItemShopBinding):RecyclerView.ViewHolder(binding.root){
    private var shopListener:ShopListener?=null

    fun setListener(listener: ShopListener){
        this.shopListener = listener
    }
    fun bind(model: ShopModel){
        binding.apply {
            txtShopName.text = model.name
            root.setOnClickListener {
                shopListener?.onShopClicked(model)
            }
        }
    }


}