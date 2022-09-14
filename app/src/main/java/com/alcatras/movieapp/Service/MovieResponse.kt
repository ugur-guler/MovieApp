package com.alcatras.movieapp.Service

import android.os.Parcelable
import com.alcatras.movieapp.DataClasses.Movies
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movies:List<Movies>

): Parcelable {
    constructor():this(mutableListOf())
}