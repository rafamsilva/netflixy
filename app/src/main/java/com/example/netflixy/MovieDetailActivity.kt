package com.example.netflixy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailActivity : AppCompatActivity() {

    private var imdbID: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val intent: Intent = getIntent()
        imdbID = intent.getStringExtra("imdbID")
        imdbID?.let {
            callServiceDeTails(it)
        }
    }

    private fun callServiceDeTails(imdbID : String) {
        imdbID?.let {
            val call = RetrofitInitializer().apiService().getMovieDetail(imdbID = it)
            call.enqueue(object : Callback<MovieDetail> {
                override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                    response.body()?.let {
                        bindView()
                    }
                }

                override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                    Log.d("eoq", "deu ruim")
                }
            })
        }
    }

    private fun bindView() {

    }
}
