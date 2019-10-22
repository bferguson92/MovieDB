package com.example.moviedb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.model.Result

class MovieAdapter(private val movieList: List<Result>, private val movieAdapterDelegate: MovieAdapterDeleegate) : RecyclerView.Adapter<MovieAdapter.CustomViewHolder> (){
    interface MovieAdapterDeleegate{
        fun getDetials(movieResult: Result)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.apply {
            movieTitle.text = movieList[position].title
            movieTitle.setOnClickListener{
                movieAdapterDelegate.getDetials(movieList[position])
            }
        }
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val movieTitle: TextView = view.findViewById(R.id.text_view_movie)
    }
}