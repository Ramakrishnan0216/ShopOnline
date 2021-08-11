package com.realmatez.shoponline.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.realmatez.shoponline.R
import com.realmatez.shoponline.base.BaseFragment
import com.realmatez.shoponline.data.DummyData
import com.realmatez.shoponline.databinding.FragmentHomeBinding
import com.realmatez.shoponline.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private  val  mainViewModel:MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        initRecycler()
        setObservers()
        setListeners()
        mainViewModel.shopAdapter.replaceNewItems(DummyData.getShops())
    }

    private fun setListeners() {

    }

    private fun setObservers() {
        mainViewModel.goToMapLiveData.observe(this.viewLifecycleOwner){
            if (it!=null && it ){
                goToMapFragment()
            }
        }

    }

    private fun goToMapFragment(){
        val action = HomeFragmentDirections.actionHomeFragmentToMapsFragment()
        Navigation.findNavController(binding.root).navigate(action)
    }

    private fun initRecycler(){
        binding.rvShops.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@HomeFragment.requireContext(),LinearLayoutManager.VERTICAL,false)
            adapter = mainViewModel.shopAdapter
        }
    }


}