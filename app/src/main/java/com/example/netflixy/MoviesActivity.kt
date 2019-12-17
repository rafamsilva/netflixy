package com.example.netflixy

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_movies.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesActivity : AppCompatActivity() {

    private lateinit var viewAdapter: MoviesAdapter
    private var searchJob: Job? = null
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            setOnQueryTextListener(object: SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    searchJob?.cancel()
                    searchJob = coroutineScope.launch {
                        newText?.let {
                            delay(1000)
                            callService(newText)
                        }
                    }
                    return false
                }
            })
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        handleIntent(intent)
        setView()
    }

    override fun onNewIntent(intent: Intent) {
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            callService(query)
        }
    }

    private fun callService(query: String?) {
        query?.let {
            val call = RetrofitInitializer().apiService().searchMovies(name = it)
            call.enqueue(object : Callback<MovieList> {
                override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                    viewAdapter.setItems(response.body()?.search?.sortedBy {movies ->
                        movies.year
                    } ?: listOf())
                }

                override fun onFailure(call: Call<MovieList>, t: Throwable) {
                    Log.d("eoq", "deu ruim")
                }
            })
        }
    }

    private fun setView() {
        viewAdapter = MoviesAdapter()
        my_recycler_view.apply {
            setHasFixedSize(true)
            // use a linear layout manager
            layoutManager = GridLayoutManager(this@MoviesActivity, 2)
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }

}
