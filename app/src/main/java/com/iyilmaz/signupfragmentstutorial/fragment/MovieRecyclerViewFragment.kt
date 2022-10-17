package com.iyilmaz.signupfragmentstutorial.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iyilmaz.signupfragmentstutorial.adapter.MovieAdapter
import com.iyilmaz.signupfragmentstutorial.databinding.FragmentMovieRecyclerViewBinding
import com.iyilmaz.signupfragmentstutorial.entity.Movie
import com.iyilmaz.signupfragmentstutorial.manager.MovieManager


class MovieRecyclerViewFragment : Fragment() {

    lateinit var binding: FragmentMovieRecyclerViewBinding

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var movieList : ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /// Static method
        movieList = MovieManager.getMovieList()

        /// object non static method
        val movieManager = MovieManager()
        movieList = movieManager.getNonStaticMovieList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieRecyclerViewBinding.inflate(inflater, container, false)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)

        binding.recyclerview.layoutManager = layoutManager
        movieAdapter = MovieAdapter(movieList)
        binding.recyclerview.adapter = movieAdapter

        return  binding.root
    }
}