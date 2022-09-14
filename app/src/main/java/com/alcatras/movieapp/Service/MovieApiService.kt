package com.alcatras.movieapp.Service

import android.content.Context
import android.widget.ProgressBar
import androidx.core.view.isVisible
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MovieApiService {
    companion object {
        private const val baseUrl = "https://api.themoviedb.org"
        private var retrofit: Retrofit? = null
        fun getInstance(context: Context): Retrofit {
            val progressBar = ProgressBar(context)
            progressBar.max = 100
            progressBar.isVisible = true
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!

        }
    }
}