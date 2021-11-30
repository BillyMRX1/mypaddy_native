package com.mrx.mypaddynative.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrx.mypaddynative.databinding.ActivityDetailBinding
import com.mrx.mypaddynative.ui.camera.CameraActivity.Companion.DISEASES_DESC
import com.mrx.mypaddynative.ui.camera.CameraActivity.Companion.DISEASES_NAME
import com.mrx.mypaddynative.ui.camera.CameraActivity.Companion.DISEASES_SOLUTION

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var tvDiseasesName: TextView
    private lateinit var tvDiseasesDesc: TextView
    private lateinit var rvDiseasesSolution: RecyclerView
    private lateinit var diseasesName: String
    private lateinit var diseasesDesc: String
    private lateinit var diseasesSolution: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentData()
        initView()
        initialize()
    }

    private fun getIntentData() {
        val extras = intent.extras
        if (extras != null){
            diseasesName = extras.getString(DISEASES_NAME).toString()
            diseasesDesc = extras.getString(DISEASES_DESC).toString()
            diseasesSolution = extras.getStringArrayList(DISEASES_SOLUTION)!!
        }
    }

    private fun initView() {
        tvDiseasesName = binding.tvDiseases
        tvDiseasesDesc = binding.tvDesc
    }

    private fun initialize() {
        tvDiseasesName.text = diseasesName
        tvDiseasesDesc.text = diseasesDesc
    }
}