package com.example.moviedb.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedb.R
import com.example.moviedb.adapter.MovieAdapter
import com.example.moviedb.fragment.InputFragment
import com.example.moviedb.model.MovieQuery
import com.example.moviedb.model.Result
import com.example.moviedb.presenter.SearchContract
import com.example.moviedb.presenter.SearchPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :
    AppCompatActivity(),
    SearchContract.View,
    InputFragment.InputFragmentListener,
    MovieAdapter.MovieAdapterDeleegate {


    private val inputFragment = InputFragment(this)
    private val presenter = SearchPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_show_search.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout_input_fragment, inputFragment)
                .commit()
        }
    }

    override fun displayResults(movieList: MovieQuery) {

        recycler_view_movies.adapter = MovieAdapter(movieList.results, this)
        recycler_view_movies.layoutManager = LinearLayoutManager(this)

    }

    override fun searchTitle(movie: String) {
        presenter.getResults(movie)
    }

    override fun getDetials(movieResult: Result) {
        intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("result", movieResult)
        startActivity(intent)

    }
}
