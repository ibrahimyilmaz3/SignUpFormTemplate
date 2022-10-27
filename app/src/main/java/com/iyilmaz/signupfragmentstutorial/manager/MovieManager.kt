package com.iyilmaz.signupfragmentstutorial.manager

import com.iyilmaz.signupfragmentstutorial.entity.Movie

class MovieManager {

    val
    companion object {
        fun getMovieList(): ArrayList<Movie> {
            val movieList = arrayListOf<Movie>()

            movieList.add("Apocalypto", 2006)
            movieList.add("Braveheart", 1995)
            movieList.add("Dragged Across Concete", 2018)
            movieList.add("Edge of Darkness", 2010)
            movieList.add("Forever Young", 1992)
            movieList.add("Gallipoli", 1984)
            movieList.add("Get the Gringo", 2012)
            movieList.add("Hacksaw Ridge", 2016)
            movieList.add("Lethal Weapon", 1987)
            movieList.add("The Year of Living Dangerously", 1982)
            movieList.add("Mad Max 2", 1981)
            movieList.add("Maverick", 1994)
            movieList.add("Payback", 1999)
            movieList.add("Ransom", 1996)
            movieList.add("Signs", 2002)
            movieList.add("The Bounty", 1984)
            movieList.add("The Passion of Christ", 2004)
            movieList.add("The Patriot", 2000)
            movieList.add("The Professor and the Madman", 2019)
            movieList.add("We Were Soldiers", 2002)

            return movieList
        }
    }
}