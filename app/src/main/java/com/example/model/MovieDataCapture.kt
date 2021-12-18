package com.example.model


import android.content.Context
import com.example.repository.MovieRepository

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MovieDataCapture @Inject constructor(

    private val repository: MovieRepository,

    private val context: Context,
    private val rideId: Long
){

    val movieDataList = repository.loadMovieData(rideId)



    fun setFavoriteMovieList(movieData: MovieData)
    {

    }

}