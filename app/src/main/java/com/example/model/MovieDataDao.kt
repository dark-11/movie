package com.example.model



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MovieDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieData(movieData: MovieData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDataList(movieDataList: List<MovieData>)

    @Query("SELECT * FROM MovieData WHERE movieId = :movieId")
    fun getMovieData(movieId: Long): List<MovieData>

    @Query("DELETE FROM MovieData")
    fun nukeData()

    @Query("DELETE FROM MovieData WHERE movieId = :movieId")
    fun deleteSelectedMovieData(movieId: Long)
}

