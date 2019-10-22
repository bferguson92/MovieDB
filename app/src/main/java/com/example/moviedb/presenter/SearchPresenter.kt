package com.example.moviedb.presenter

import android.util.Log
import com.example.moviedb.factory.MovieFactory
import com.example.moviedb.model.MovieQuery
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchPresenter(private val view: SearchContract.View) : SearchContract.Presenter {

    private val movieFactory = MovieFactory()

    override fun getResults(movie: String)  {
        Log.d("TAG_X", "Presenter called")

        movieFactory.getResults(movie).enqueue(object : Callback<MovieQuery> {
            override fun onFailure(call: Call<MovieQuery>, t: Throwable) {
                Log.d("TAX_X", t.toString())
            }

            override fun onResponse(
                call: Call<MovieQuery>,
                response: Response<MovieQuery>
            ) {
                Log.d("TAG_X", "On response called")
                response.body()?.let{result->
                    Log.d("TAG_X" ,"response.body.let called")
                    view.displayResults(result)
                }
            }
        })

    }

}