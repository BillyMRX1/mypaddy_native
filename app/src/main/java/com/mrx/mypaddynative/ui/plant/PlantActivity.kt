package com.mrx.mypaddynative.ui.plant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrx.mypaddynative.data.Plant
import com.mrx.mypaddynative.data.PlantData
import com.mrx.mypaddynative.databinding.ActivityPlantBinding
import com.mrx.mypaddynative.ui.camera.CameraActivity
import com.mrx.mypaddynative.ui.camera.CameraActivity.Companion.DISEASES_NAME
import com.mrx.mypaddynative.ui.camera.CameraActivity.Companion.DISEASES_DESC
import com.mrx.mypaddynative.ui.camera.CameraActivity.Companion.DISEASES_IMAGE
import com.mrx.mypaddynative.ui.camera.CameraActivity.Companion.DISEASES_SOLUTION
import com.mrx.mypaddynative.ui.detail.DetailActivity

class PlantActivity : AppCompatActivity(), PlantAdapter.OnItemClickCallback {
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

        diseasesAdapter.setOnItemClickCallback(this)
    }

    companion object{
        const val IS_SCAN = "is_scan"
    }

    override fun onItemClicked(data: Plant) {
        if (isScan) {
            val intent = Intent(this, CameraActivity::class.java)
            intent.putExtra(DISEASES_NAME, data.name)
            intent.putExtra(DISEASES_DESC, data.detail)
            intent.putExtra(DISEASES_SOLUTION, data.solution)
            intent.putExtra(DISEASES_IMAGE, data.image)
            startActivity(intent)
        } else {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DISEASES_NAME, data.name)
            intent.putExtra(DISEASES_DESC, data.detail)
            intent.putExtra(DISEASES_SOLUTION, data.solution)
            intent.putExtra(DISEASES_IMAGE, data.image)
            startActivity(intent)
        }
    }
}