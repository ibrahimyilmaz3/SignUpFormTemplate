package com.iyilmaz.signupfragmentstutorial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iyilmaz.signupfragmentstutorial.databinding.RecyclerViewRowBinding
import com.iyilmaz.signupfragmentstutorial.entity.Movie

class MovieAdapter(private val mList: ArrayList<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = RecyclerViewRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = mList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = mList.size

}