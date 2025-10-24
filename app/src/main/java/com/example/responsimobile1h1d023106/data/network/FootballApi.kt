package com.example.responsimobile1h1d023106.data.networ
import com.example.responsimobile1h1d023106.data.model.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface FootballApi {
    // @GET: Metode HTTP untuk mengambil data
    // "v4/teams/512": Alamat spesifik (endpoint) setelah BASE_URL
    @GET("v4/teams/511")
    suspend fun getTeamDetails(
        // @Header: Menambahkan info tambahan di header permintaan [cite: 3229]
        // "X-Auth-Token": Nama header yang diminta API football-data
        // token: String: Nilai token yang akan kita kirim
        @Header("X-Auth-Token") token: String
        // Response<TeamResponse>: Hasilnya diharapkan sesuai cetakan TeamResponse
    ): Response<TeamResponse>
}