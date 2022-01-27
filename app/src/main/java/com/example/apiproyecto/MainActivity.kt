package com.example.apiproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiproyecto.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FoodAdapter
    private val foodImage = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buscar.setOnQueryTextListener(this)
        initRecyclerView()
    }
    private fun initRecyclerView(){
        adapter= FoodAdapter(foodImage)
        binding.rvFood.layoutManager = LinearLayoutManager(this)
        binding.rvFood.adapter = adapter
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.edamam.com/api/food-database/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



    private fun searchByName(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getNutry("$query/parser")
            val food= call.body()
            runOnUiThread {
                if (call.isSuccessful){
                val images = food?.images ?: emptyList()
                    foodImage.clear()
                    foodImage.addAll(images)
                    adapter.notifyDataSetChanged()
                //show Recyclerview
                } else{
                    showError()
                }
            }

        }
    }

    private fun showError() {
        Toast.makeText(this,"Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()){
            searchByName(query.toLowerCase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}