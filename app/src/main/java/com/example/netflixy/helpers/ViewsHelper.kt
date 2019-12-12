package com.example.netflixy.helpers

import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*

fun ImageView.load(url: String) {
    Glide.with(this.context)
        .load(url)
        .centerCrop()
        .into(movie_poster)
}
