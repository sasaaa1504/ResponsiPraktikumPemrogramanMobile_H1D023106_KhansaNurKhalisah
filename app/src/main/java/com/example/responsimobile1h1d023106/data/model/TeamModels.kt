package com.example.responsimobile1h1d023106.data.model
import com.google.gson.annotations.SerializedName


data class TeamResponse(
    @SerializedName("coach")
    val coach: Coach?,

    @SerializedName("squad")
    val squad: List<Player>?
)


data class Coach(
    @SerializedName("name")
    val name: String?,

    @SerializedName("nationality")
    val nationality: String?,

    @SerializedName("dateOfBirth")
    val dateOfBirth: String?
)


data class Player(
    @SerializedName("name")
    val name: String?,

    @SerializedName("position")
    val position: String?,

    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,

    @SerializedName("nationality")
    val nationality: String?
)
