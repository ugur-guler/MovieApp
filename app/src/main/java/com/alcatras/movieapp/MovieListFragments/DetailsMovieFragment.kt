package com.alcatras.movieapp.MovieListFragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alcatras.movieapp.R
import com.alcatras.movieapp.databinding.FragmentDetailsMovieBinding

class DetailsMovieFragment : Fragment() {
    private lateinit var binding: FragmentDetailsMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentDetailsMovieBinding.inflate(inflater,container,false)
        return binding.root
    }
}