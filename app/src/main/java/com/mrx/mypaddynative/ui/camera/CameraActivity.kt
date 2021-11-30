package com.mrx.mypaddynative.ui.camera

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mrx.mypaddynative.databinding.ActivityCameraBinding
import com.mrx.mypaddynative.tflite.Classifier
import com.mrx.mypaddynative.tflite.IClassifier
import com.mrx.mypaddynative.ui.detail.DetailActivity
import com.wonderkiln.camerakit.*
import java.text.NumberFormat
import java.util.concurrent.Executors

class CameraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraBinding
    private lateinit var classifier: Classifier
    private val executor = Executors.newSingleThreadExecutor()
    private lateinit var diseasesName: String
    private lateinit var diseasesDesc: String
    private lateinit var diseasesSolution: ArrayList<String>
    private var diseasesImage: Int = 0
    private lateinit var result: List<IClassifier.Recognition>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentData()
        cameraPreparation()
        prepareButtons()
        initTensorFlowAndLoadModel()
    }

    private fun getIntentData() {
        val extras = intent.extras
        if (extras != null){
            diseasesName = extras.getString(DISEASES_NAME).toString()
            diseasesDesc = extras.getString(DISEASES_DESC).toString()
            diseasesSolution = extras.getStringArrayList(DISEASES_SOLUTION)!!
            diseasesImage = extras.getInt(DISEASES_IMAGE)
        }
    }

    private fun cameraPreparation() {
        binding.cameraView.start()
        binding.cameraView.addCameraKitListener(object : CameraKitEventListener {
            override fun onEvent(p0: CameraKitEvent?) {}

            override fun onError(p0: CameraKitError?) {}

            override fun onImage(p0: CameraKitImage) {
                binding.cameraView.stop()
                var bitmap = p0.bitmap
                bitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false)
                result = classifier.recognizeImage(bitmap)

                for (i in result.indices) {
                    if (result[i].title == diseasesName) {
                        binding.apply {
                            viewSuccess.tvDiseases.text = diseasesName
                            viewSuccess.tvDesc.text = diseasesDesc
                            val confidencePercent = (result[i].confidence*100).toInt()
                            viewSuccess.tvAkurasi.text = "$confidencePercent%"
                        }
                        binding.viewSuccess.root.visibility = View.VISIBLE
                    }
                }
            }

            override fun onVideo(p0: CameraKitVideo?) {}
        })
    }

    private fun prepareButtons() {
        binding.btnShutter.setOnClickListener {
            binding.cameraView.captureImage()
        }

        binding.viewSuccess.btnNext.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DISEASES_NAME, diseasesName)
            intent.putExtra(DISEASES_DESC, diseasesDesc)
            intent.putExtra(DISEASES_SOLUTION, diseasesSolution)
            intent.putExtra(DISEASES_IMAGE, diseasesImage)
            startActivity(intent)
        }
    }

    override fun onPause() {
        binding.cameraView.stop()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        executor.execute { classifier.close() }
    }

    private fun initTensorFlowAndLoadModel() {
        executor.execute {
            try {
                classifier = Classifier.create(
                    assets,
                    MODEL_PATH,
                    LABEL_PATH,
                    INPUT_SIZE
                )
            } catch (e: Exception) {
                throw RuntimeException("Error initializing TensorFlow!", e)
            }
        }
    }

    companion object {
        private const val MODEL_PATH = "model.tflite"
        private const val LABEL_PATH = "labels.txt"
        private const val INPUT_SIZE = 224
        const val DISEASES_NAME = "diseases_name"
        const val DISEASES_DESC = "diseases_desc"
        const val DISEASES_SOLUTION = "diseases_solution"
        const val DISEASES_IMAGE = "diseases_image"
    }
}