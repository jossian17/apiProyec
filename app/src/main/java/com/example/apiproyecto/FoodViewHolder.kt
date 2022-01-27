package com.example.apiproyecto

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apiproyecto.databinding.ItemFoodBinding
import com.squareup.picasso.Picasso

class FoodViewHolder (view: View): RecyclerView.ViewHolder(view){
    private val binding = ItemFoodBinding.bind(view)
    fun bind (image:String){
        Picasso.get().load(image).into(binding.ivFood)
    }
}