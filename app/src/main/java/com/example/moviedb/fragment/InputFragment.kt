package com.example.moviedb.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviedb.R
import com.example.moviedb.presenter.SearchPresenter
import kotlinx.android.synthetic.main.input_fragment.*

class InputFragment(private val Listener: InputFragmentListener) : Fragment(){

    interface InputFragmentListener {
        fun searchTitle(movie: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_search.setOnClickListener{
            Listener.searchTitle(edit_text_search.text.toString())
        }
    }


}