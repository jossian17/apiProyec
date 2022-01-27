package com.example.apiproyecto

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface APIService {
    @GET ("/top.json")
    suspend fun getNutry(@Url url:String ):Response<Calorias>
}