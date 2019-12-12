package com.example.netflixy

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: Int,
    @SerializedName("Poster")
    val poster: String,
    val imdbID: String
) : Parcelable