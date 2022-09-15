package com.alcatras.movieapp.MovieListFragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.alcatras.movieapp.Adapters.MoviesAdapter
import com.alcatras.movieapp.DataClasses.Category
import com.alcatras.movieapp.DataClasses.Movies
import com.alcatras.movieapp.R
import com.alcatras.movieapp.Service.MovieApiInterface
import com.alcatras.movieapp.Service.MovieApiService
import com.alcatras.movieapp.Service.MovieResponse
import com.alcatras.movieapp.databinding.FragmentMovieTypeBinding
import kotlinx.android.synthetic.main.fragment_movie_type.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieTypeFragment : Fragment() {

    private lateinit var binding: FragmentMovieTypeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPopularMovieData {
            binding.recyclerView.adapter=MoviesAdapter(it)
            println(it)
        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentMovieTypeBinding.inflate(inflater, container, false)
        return binding.root
    }
    private fun getPopularMovieData(callback:(List<Movies>)->Unit){
        val apiService= MovieApiService.getInstance(requireContext()).create(MovieApiInterface::class.java)
        apiService.getPopularMovieList().enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                response.body().let {
                    if (it != null) {
                        println(it.movies.size)
                    }
                }
                return callback(response.body()!!.movies)
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                t.printStackTrace()


            }
        })
    }




}