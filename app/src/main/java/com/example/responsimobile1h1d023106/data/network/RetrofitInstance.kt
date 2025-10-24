package com.example.responsimobile1h1d023106.data.network

import com.example.responsimobile1h1d023106.data.networ.FootballApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.gson.GsonConverterFactory.*


object RetrofitInstance {

    val api: FootballApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL) // Pakai alamat dasar dari Constants

            .addConverterFactory(create())
            .build()

            .create(FootballApi::class.java)
    }
}