package com.example.netflixy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixy.helpers.load
import kotlinx.android.synthetic.main.movie_item.view.*

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var movies: ArrayList<Movie> = ArrayList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        bindView(movie, holder.itemView)
    }

    private fun bindView(movie: Movie, view: View) {
        with(view) {
            movie_poster.load(movie.poster)
            movie_title.text = movie.title
            movie_year.text = movie.year.toString()
        }

    }

    fun setItems(item: List<Movie>) {
        movies.clear()
        movies.addAll(item)
        notifyDataSetChanged()
    }
}
