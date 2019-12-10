package com.example.netflixy

import com.google.gson.annotations.SerializedName

data class Movie (
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: Int,
    @SerializedName("Poster")
    val poster: String,
    val imdbID: String
)