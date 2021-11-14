package com.mrx.mypaddynative.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import com.mrx.mypaddynative.R
import com.mrx.mypaddynative.databinding.ActivityMainBinding

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
            Toast.makeText(this, "ini scan", Toast.LENGTH_SHORT).show()
        }

        btnDiseases.setOnClickListener {
            Toast.makeText(this, "ini penyakit", Toast.LENGTH_SHORT).show()
        }
    }
}