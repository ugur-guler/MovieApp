package com.alcatras.movieapp.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alcatras.movieapp.Activities.SelectedMovieActivity
import com.alcatras.movieapp.DataClasses.Movies

import com.alcatras.movieapp.databinding.FirstlayoutBinding


class MoviesAdapter(private val movieType  : List<Movies>) : RecyclerView.Adapter<MoviesAdapter.Holder>() {


    class Holder(val binding :FirstlayoutBinding ) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding=FirstlayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)

    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.tvCategoryName.text="Popular"
        holder.binding.rvHorizontal.layoutManager=LinearLayoutManager(holder.binding.root.context,LinearLayoutManager.HORIZONTAL,false)
        holder.binding.rvHorizontal.adapter= MovieTypeAdapter(movieType)
        holder.binding.tvAll.setOnClickListener {
            val intent=Intent(holder.binding.root.context,SelectedMovieActivity::class.java)
            intent.putExtra("category",ArrayList(movieType))
            holder.binding.root.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movieType.size
    }

}