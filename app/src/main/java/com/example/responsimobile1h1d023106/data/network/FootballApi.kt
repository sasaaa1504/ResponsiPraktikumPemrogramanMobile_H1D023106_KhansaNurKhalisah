package com.example.responsimobile1h1d023106.data.networ
import com.example.responsimobile1h1d023106.data.model.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface FootballApi {

    @GET("v4/teams/511")
    suspend fun getTeamDetails(

        @Header("X-Auth-Token") token: String

    ): Response<TeamResponse>
}