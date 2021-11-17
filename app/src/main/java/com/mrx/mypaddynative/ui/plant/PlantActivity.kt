package com.mrx.mypaddynative.ui.plant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrx.mypaddynative.data.Plant
import com.mrx.mypaddynative.data.PlantData
import com.mrx.mypaddynative.databinding.ActivityPlantBinding

class PlantActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlantBinding
    private lateinit var rvDiseases: RecyclerView
    private var listDiseases: ArrayList<Plant> = arrayListOf()
    private var isScan: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentData()
        initView()
        prepareAdapter()
    }

    private fun getIntentData(){
        val extras = intent.extras
        if (extras != null){
            isScan = extras.getBoolean(IS_SCAN)
        }
    }

    private fun initView(){
        rvDiseases = binding.rvPlant
    }

    private fun prepareAdapter(){
        rvDiseases.setHasFixedSize(true)
        listDiseases.addAll(PlantData.listData)
        rvDiseases.layoutManager = LinearLayoutManager(this)
        val diseasesAdapter = PlantAdapter(listDiseases, isScan)
        rvDiseases.adapter = diseasesAdapter
    }

    companion object{
        const val IS_SCAN = "is_scan"
    }
}