package com.example.netflixy

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(".")
    fun searchMovies(@Query("apikey") apiKey: String = "399b5e21", @Query("s") name: String, @Query("type") type: String = "movie"): Call<MovieList>

    @GET("?apikey=399b5e21&i={imdbID}")
    fun getMovieDetail(@Path("imdbID") imdbID: String): Call<MovieDetail>
}