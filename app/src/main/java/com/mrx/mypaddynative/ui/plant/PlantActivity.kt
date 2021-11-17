package com.mrx.mypaddynative.ui.plant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mrx.mypaddynative.databinding.ActivityPlantBinding

class PlantActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlantBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}