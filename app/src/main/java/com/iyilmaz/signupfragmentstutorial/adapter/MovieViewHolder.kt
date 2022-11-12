package com.iyilmaz.signupfragmentstutorial.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.iyilmaz.signupfragmentstutorial.databinding.RecyclerViewRowBinding
import com.iyilmaz.signupfragmentstutorial.entity.Movie

class MovieViewHolder(private val binding: RecyclerViewRowBinding):ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        binding.tvMovieName.text = movie.name
        binding.tvMovieYear.text = movie.year.toString()
        binding.ivMovie.setImageResource(movie.pic!!)
    }
}