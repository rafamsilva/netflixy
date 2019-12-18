package com.example.netflixy

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class MovieDetail (
    @SerializedName("Released")
    val released: Date,
    @SerializedName("Runtime")
    val runtime: String,
    @SerializedName("Genre")
    val genre: String,
    @SerializedName("Director")
    val director: String,
    @SerializedName("Actors")
    val actors: String,
    @SerializedName("Metascore")
    val metascore: Int
) : Parcelable, Movie()