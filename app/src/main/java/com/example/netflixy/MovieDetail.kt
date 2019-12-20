package com.example.netflixy

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class MovieDetail (
    @SerializedName("Released")
    val released: String,
    @SerializedName("Runtime")
    val runtime: String,
    @SerializedName("Genre")
    val genre: String,
    @SerializedName("Director")
    val director: String,
    @SerializedName("Actors")
    val actors: String,
    @SerializedName("Language")
    val language: String,
    @SerializedName("Plot")
    val description: String,
    @SerializedName("Production")
    val production: String,
    val imdbRating: Float
) : Parcelable, Movie()