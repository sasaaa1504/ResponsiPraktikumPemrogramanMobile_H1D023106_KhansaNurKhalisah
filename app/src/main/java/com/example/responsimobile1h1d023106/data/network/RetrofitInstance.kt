package com.example.responsimobile1h1d023106.data.network

import com.example.responsimobile1h1d023106.data.networ.FootballApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.gson.GsonConverterFactory.*

// 'object' membuat ini jadi Singleton, hanya ada 1 instance [cite: 2036]
object RetrofitInstance {
    // 'lazy' artinya objek Retrofit baru dibuat saat pertama kali dibutuhkan [cite: 2171]
    val api: FootballApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL) // Pakai alamat dasar dari Constants
            // Pakai Gson untuk mengubah JSON jadi objek Kotlin [cite: 1868]
            .addConverterFactory(create())
            .build() // Bangun objek Retrofit
            // Buat implementasi dari interface FootballApi kita
            .create(FootballApi::class.java)
    }
}