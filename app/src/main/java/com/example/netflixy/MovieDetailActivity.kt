package com.example.netflixy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import com.example.netflixy.helpers.load
import kotlinx.android.synthetic.main.activity_movie_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailActivity : AppCompatActivity() {

    private var imdbID: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        imdbID = intent.getStringExtra("imdbID")
        imdbID?.let {
            callServiceDeTails(it)
        }
    }

    private fun callServiceDeTails(imdbID : String) {
        val call = RetrofitInitializer().apiService().getMovieDetail(imdbID = imdbID)
        call.enqueue(object : Callback<MovieDetail> {
            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                response?.body()?.let {
                    bindView(it)
                }
            }

            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                Log.d("eoq", "deu ruim")
            }
        })
    }

    private fun bindView(movie : MovieDetail) {
        movie_detail_poster.load(movie.poster, movie_detail_poster)
        movie_detail_title.text = movie.title
        movie_detail_imdb.text = movie.imdbRating.toString()
        movie_detail_runtime.text = movie.runtime
        movie_detail_year.text = movie.year.toString()
    }
}
