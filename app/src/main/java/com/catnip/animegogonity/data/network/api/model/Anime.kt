package com.catnip.animegogonity.data.network.api.model


import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("animeId")
    val animeId: String,
    @SerializedName("animeImg")
    val animeImg: String,
    @SerializedName("animeTitle")
    val animeTitle: String,
    @SerializedName("animeUrl")
    val animeUrl: String,
    @SerializedName("releasedDate")
    val releasedDate: String,
    @SerializedName("episodeUrl")
    val episodeUrl: String
)