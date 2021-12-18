package com.example.repository

import com.example.model.MovieData
import com.example.model.MovieDataDao
import com.example.repository.Repository

import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject
    constructor(private val movieDataDao: MovieDataDao)
        : Repository {

    init {
        Timber.d("Injection Repository")
    }

    fun loadMovieData(rideId: Long): List<MovieData> {
        return movieDataDao.getMovieData(rideId)

    }
    fun saveData(movieData: MovieData) {
        movieDataDao.insertMovieData(movieData)
    }

    fun saveData(movieDataList: List<MovieData>) {
        movieDataDao.insertMovieDataList(movieDataList)
    }


}
