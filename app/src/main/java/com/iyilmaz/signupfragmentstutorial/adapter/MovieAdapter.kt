package com.iyilmaz.signupfragmentstutorial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iyilmaz.signupfragmentstutorial.databinding.MovieItemViewBinding
import com.iyilmaz.signupfragmentstutorial.entity.Movie

class MovieAdapter(private val mList: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Movie = mList[position]
        holder.bind(item)
    }


    class ViewHolder(private val binding: MovieItemViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Movie) {
           binding.tvName.text = item.name
           binding.tvYear.text = item.year.toString()
        }
    }


   // inner class ViewHolder(val binding: MovieItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }
}

