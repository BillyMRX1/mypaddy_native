package com.mrx.mypaddynative.ui.plant

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mrx.mypaddynative.R
import com.mrx.mypaddynative.data.Plant

class PlantAdapter(private val listDiseases: ArrayList<Plant>, private val isScan: Boolean) : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_detail, p0, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val diseases = listDiseases[p1]
        p0.apply {
            tvName.text = diseases.name
            tvDetail.text = diseases.detail
        }

        if (isScan) {
            Glide.with(p0.itemView.context)
                .load(R.drawable.ic_scanner)
                .into(p0.img)
        } else {
            Glide.with(p0.itemView.context)
                .load(R.drawable.paddy_diseases)
                .into(p0.img)
        }

        p0.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listDiseases[p0.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listDiseases.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_desc)
        var img: ImageView = itemView.findViewById(R.id.img_scan)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Plant)
    }
}