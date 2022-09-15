package com.alcatras.movieapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alcatras.movieapp.DataClasses.Movies
import com.alcatras.movieapp.databinding.SecondlayoutBinding
import com.bumptech.glide.Glide

class MovieTypeAdapter(val movieType: List<Movies>) : RecyclerView.Adapter<MovieTypeAdapter.Holder>() {
    class Holder(val binding : SecondlayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding=SecondlayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)

    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        var url=movieType[position].posterPath
        println(url)

            Glide.with(holder.binding.root.context)
                .load("https://image.tmdb.org/t/p/original"+url)
                .into(holder.binding.ivMovie)





        holder.binding.tvMovieName.text=movieType[position].title





    }

    override fun getItemCount(): Int {
        return movieType.size
    }

}