package com.example.service

import com.example.model.MovieData
import com.example.repository.MovieRepository
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieCaptureService @Inject constructor(private val repository: MovieRepository){


    fun persistMovieCaptureData(movieData: MovieData) {
        var movieData = MovieData(movieData)
        repository.saveData(movieData )
    }
}