package com.example.moviedb.factory

import com.example.moviedb.model.MovieQuery
import com.example.moviedb.util.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieFactory {
    private lateinit var movieService: MovieService

    init{
        movieService = createMovieService(getRetroFiInstance())
    }

    private fun getRetroFiInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createMovieService(retrofit: Retrofit) : MovieService {
        return retrofit.create(MovieService::class.java)
    }

    fun getResults(movie: String): Call<MovieQuery>{
        return movieService.getMovies(Constants.API_KEY ,movie)
    }
}