package com.example.service

import com.example.model.MovieResponse

import io.reactivex.Observable
import retrofit2.http.*


interface ApiService {

    @GET("3/movie/popular")
    fun getMovieList(@Query(value = "api_key", encoded = true) apiKey: String): Observable<MovieResponse>


}