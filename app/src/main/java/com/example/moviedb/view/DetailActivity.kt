package com.example.moviedb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviedb.R
import com.example.moviedb.model.Result
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val result = intent.getSerializableExtra("result") as Result
        text_view_name.text = result.title
        text_view_rating.text = result.voteAverage.toString()

    }
}
