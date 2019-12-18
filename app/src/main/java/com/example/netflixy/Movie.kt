package com.example.netflixy

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
open class Movie : Parcelable {
    @SerializedName("Title")
    var title: String = ""
    @SerializedName("Year")
    var year: Int = 0
    @SerializedName("Poster")
    var poster: String = ""
    val imdbID: String = ""
}