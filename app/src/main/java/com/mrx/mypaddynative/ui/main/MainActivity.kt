package com.mrx.mypaddynative.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import com.mrx.mypaddynative.R
import com.mrx.mypaddynative.databinding.ActivityMainBinding
import com.mrx.mypaddynative.ui.plant.PlantActivity
import com.mrx.mypaddynative.ui.plant.PlantActivity.Companion.IS_SCAN

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var btnScan: LinearLayout
    private lateinit var btnDiseases: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        btnSetup()
    }

    private fun initView() {
        btnScan = binding.btnScan
        btnDiseases = binding.btnDiseases
    }

    private fun btnSetup() {
        btnScan.setOnClickListener {
            val intent = Intent(this, PlantActivity::class.java)
            intent.putExtra(IS_SCAN, true)
            startActivity(intent)
        }

        btnDiseases.setOnClickListener {
            val intent = Intent(this, PlantActivity::class.java)
            intent.putExtra(IS_SCAN, false)
            startActivity(intent)
        }
    }
}