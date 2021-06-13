package com.example.mainproject.data.network

import com.example.mainproject.data.network.models.SpaceXLaunch
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitRepository {

    @GET("launches")
    suspend fun getLaunches(): Response<List<SpaceXLaunch>>
}