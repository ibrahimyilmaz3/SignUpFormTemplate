package com.iyilmaz.signupfragmentstutorial.manager

import com.iyilmaz.signupfragmentstutorial.R
import com.iyilmaz.signupfragmentstutorial.entity.Movie

class MovieManager {

    companion object {
        fun getMovieList() : ArrayList<Movie> {

            val movieList = arrayListOf<Movie>()
            movieList.add(Movie("Apocalypto", 2006, R.drawable.apocalypto))
            movieList.add(Movie("Braveheart", 1995,R.drawable.braveheart))
            movieList.add(Movie("Dragged Across Concrete", 2018,R.drawable.draggedaccrossconcete))
            movieList.add(Movie("Edge of Darkness", 2010,R.drawable.edgeofdarkness))
            movieList.add(Movie("Forever Young", 1992,R.drawable.foreveryoung))
            movieList.add(Movie("Gallipoli", 1984,R.drawable.gallipoli))
            movieList.add(Movie("Get the Gringo", 2012,R.drawable.getthegringo))
            movieList.add(Movie("Hacksaw Ridge", 2016,R.drawable.hacksawridge))
            movieList.add(Movie("Lethal Weapon", 1987,R.drawable.lethalweapon))
            movieList.add(Movie("Mad Max 2", 1981,R.drawable.madmax))
            movieList.add(Movie("Maverick", 1994,R.drawable.maverick))
            movieList.add(Movie("Payback", 1999,R.drawable.payback))
            movieList.add(Movie("Ransom", 1996,R.drawable.ransom))
            movieList.add(Movie("Signs", 2002,R.drawable.signs))
            movieList.add(Movie("The Bounty", 1984,R.drawable.thebounty))
            movieList.add(Movie("The Passion of Christ", 2004,R.drawable.thepassionofchrist))
            movieList.add(Movie("The Patriot", 2000,R.drawable.thepatriot))
            movieList.add(Movie("The Professor and the Madman", 2019,R.drawable.theprofessorandthemadman))
            movieList.add(Movie("The Year of Living Dangerously", 1982,R.drawable.livingdangerously))
            movieList.add(Movie("We Were Soldiers", 2002,R.drawable.weweresoldiers))

            return movieList
        }
    }

}

