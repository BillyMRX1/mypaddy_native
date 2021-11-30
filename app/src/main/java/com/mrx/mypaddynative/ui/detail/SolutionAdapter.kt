package com.mrx.mypaddynative.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrx.mypaddynative.R

class SolutionAdapter(val listSolution: ArrayList<String>) : RecyclerView.Adapter<SolutionAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_solution, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.tvSolution.text = listSolution[position]
    }

    override fun getItemCount(): Int {
        return listSolution.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvSolution: TextView = itemView.findViewById(R.id.tv_solution)
    }
}