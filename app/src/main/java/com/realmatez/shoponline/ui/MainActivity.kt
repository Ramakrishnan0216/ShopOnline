package com.realmatez.shoponline.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.realmatez.shoponline.base.BaseActivity
import com.realmatez.shoponline.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(){
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}