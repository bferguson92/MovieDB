package com.example.moviedb.factory

import com.example.moviedb.model.MovieQuery
import com.example.moviedb.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService{

    @GET("search/movie")
    fun getMovies(@Query("api_key")apiKey: String, @Query("query")movieName: String) : Call<MovieQuery>
}