package com.example.netflixy

import android.content.Intent
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
        val context = this
        call.enqueue(object: Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                val intent = Intent(context, MoviesActivity::class.java)
                intent.putParcelableArrayListExtra("movies", ArrayList(response.body()?.search?.sortedBy { it.year } ?: listOf()))
                startActivity(intent)
            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                d("eoq", "deu ruim")
            }
        })
    }

}
