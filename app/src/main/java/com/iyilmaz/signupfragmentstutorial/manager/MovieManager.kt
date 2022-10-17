package com.iyilmaz.signupfragmentstutorial.manager

import com.iyilmaz.signupfragmentstutorial.entity.Movie

class MovieManager {

    companion object {
        fun getMovieList() : ArrayList<Movie> {
            val movieList = arrayListOf<Movie>()

            movieList.add( Movie("SpiderMan", 2020))
            movieList.add( Movie("Tenet", 2021))
            movieList.add( Movie("Batman", 2018))
            movieList.add( Movie("Iron Man", 2012))
            movieList.add( Movie("Avengers", 2013))
            movieList.add( Movie("Avengers 1", 2014))
            movieList.add( Movie("Avengers 3", 2015))
            movieList.add( Movie("Avengers X", 2025))

//            return arrayListOf(
//                Movie("SpiderMan", 2020),
//                Movie("SpiderMan", 2020),
//                Movie("SpiderMan", 2020)
//            )

            return movieList
        }
    }

    fun getNonStaticMovieList() : ArrayList<Movie> {
        val movieList = arrayListOf<Movie>()

        movieList.add( Movie("SpiderMan", 2020))
        movieList.add( Movie("Tenet", 2021))
        movieList.add( Movie("Batman", 2018))
        movieList.add( Movie("Iron Man", 2012))
        movieList.add( Movie("Avengers", 2013))
        movieList.add( Movie("Avengers 1", 2014))
        movieList.add( Movie("Avengers 3", 2015))
        movieList.add( Movie("Avengers X", 2025))

//            return arrayListOf(
//                Movie("SpiderMan", 2020),
//                Movie("SpiderMan", 2020),
//                Movie("SpiderMan", 2020)
//            )

        return movieList
    }
}