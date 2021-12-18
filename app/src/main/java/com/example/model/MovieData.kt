package com.example.model

import androidx.room.Entity

@Entity
data class MovieData(
    var movieId: Long,
    var palyListId: Long,

    var favorite: Boolean
) {
    constructor(movieData: MovieData) : this(
        movieData.movieId,
        movieData.palyListId,

        true
    ) {

    }
}
