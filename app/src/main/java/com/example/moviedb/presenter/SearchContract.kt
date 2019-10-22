package com.example.moviedb.presenter

import com.example.moviedb.model.MovieQuery

interface SearchContract {
    interface Presenter{
        fun getResults(movie: String)
    }

    interface View{
        fun displayResults(movieList: MovieQuery)
    }
}