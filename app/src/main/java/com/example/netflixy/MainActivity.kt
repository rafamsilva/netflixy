package com.example.netflixy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val call = RetrofitInitializer().apiService().searchMovies(name = "batman")
        call.enqueue(object: Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                d("teste", response.body().toString())
            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                d("eoq", "deu ruim")
            }
        })
    }

}
