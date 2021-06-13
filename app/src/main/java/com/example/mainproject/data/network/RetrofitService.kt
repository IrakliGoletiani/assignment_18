package com.example.mainproject.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private const val BASE_URL = "https://api.spacexdata.com/v3/"

    val api: RetrofitRepository by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitRepository::class.java)
    }
}