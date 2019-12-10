package com.example.netflixy

import com.google.gson.annotations.SerializedName

data class MovieList (
    @SerializedName("Search")
    val search: List<Movie>
)