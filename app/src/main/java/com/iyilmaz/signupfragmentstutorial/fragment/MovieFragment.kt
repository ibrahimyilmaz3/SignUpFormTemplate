package com.iyilmaz.signupfragmentstutorial.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iyilmaz.signupfragmentstutorial.adapter.MovieAdapter
import com.iyilmaz.signupfragmentstutorial.databinding.FragmentMovieBinding
import com.iyilmaz.signupfragmentstutorial.entity.Movie
import com.iyilmaz.signupfragmentstutorial.manager.MovieManager

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var movieList: ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieList = MovieManager.getMovieList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater,container,false)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        binding.moviesRV.layoutManager = layoutManager
        movieAdapter = MovieAdapter(movieList)
        binding.moviesRV.adapter = movieAdapter
        return binding.root
    }

}