package com.alcatras.movieapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alcatras.movieapp.Adapters.MovieTypeAdapter
import com.alcatras.movieapp.DataClasses.Movies
import com.alcatras.movieapp.R
import com.alcatras.movieapp.databinding.ActivitySelectedMovie2Binding

class SelectedMovieActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySelectedMovie2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySelectedMovie2Binding.inflate(layoutInflater)

        setContentView(binding.root)


        val intent=intent
        val movies=intent.getSerializableExtra("category") as ArrayList<Movies>
        binding.recyclerView.layoutManager=GridLayoutManager(this , 3)
        binding.recyclerView.adapter=MovieTypeAdapter(movies)
        binding.tvCategory.text="Popular"



    }
}