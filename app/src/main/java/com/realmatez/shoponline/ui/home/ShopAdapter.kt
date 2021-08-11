package com.realmatez.shoponline.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.realmatez.shoponline.databinding.ItemShopBinding
import com.realmatez.shoponline.models.ShopModel

class ShopAdapter:RecyclerView.Adapter<ShopViewHolder>() {
    private var shopListener:ShopListener?=null

    fun setListener(listener: ShopListener){
        this.shopListener = listener
    }
    private  val mDataSet:ArrayList<ShopModel> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val binding = ItemShopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val shopViewHolder = ShopViewHolder(binding)
        shopListener?.let { shopViewHolder.setListener(it) }
        return  shopViewHolder
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
      holder.bind(mDataSet[position])
    }

    override fun getItemCount(): Int {
      return mDataSet.size
    }
    fun replaceNewItems(items:List<ShopModel>){
        mDataSet.clear()
        mDataSet.addAll(items)
        notifyDataSetChanged()
    }
}

interface ShopListener{
    fun onShopClicked(shop:ShopModel)
}