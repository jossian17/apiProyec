package com.example.apiproyecto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val datos:List<String>) : RecyclerView.Adapter<FoodViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return FoodViewHolder(layoutInflater.inflate(R.layout.item_food,parent,false))
    }

    override fun getItemCount(): Int = datos.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = datos[position]
        holder.bind(item)
    }

}