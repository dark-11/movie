package com.example.service

import com.example.model.MovieResponse
import io.reactivex.Observable

object Api {
    fun makeApiCall(apiService: ApiService, token: String): Observable<MovieResponse> {
        return apiService.getMovieList(token)
    }
}