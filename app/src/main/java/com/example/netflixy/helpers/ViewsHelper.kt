package com.example.netflixy.helpers

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.netflixy.R

fun ImageView.load(url: String, element : ImageView) {
    Glide.with(this.context)
        .load(url)
        .placeholder(R.drawable.no_image)
        .error(R.drawable.no_image)
        .into(element)
}
