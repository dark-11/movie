package com.zeromotorcycles.nextgen.di.module

import android.content.Context
import androidx.room.Room
import com.example.model.MovieDataCapture
import com.example.model.MovieDataDao
import com.example.repository.MovieRepository
import com.example.room.AppDatabase
import com.example.service.MovieCaptureService
import com.zeromotorcycles.nextgen.di.qualifier.ApplicationQualifier
import dagger.Module
import dagger.Provides
import io.reactivex.annotations.NonNull
import javax.inject.Singleton


@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationQualifier context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "MovieData.db").allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideMovieDataDao(@NonNull database: AppDatabase): MovieDataDao {
        return database.rideDataDao()
    }
    @Provides
    @Singleton
    fun provideMovieCaptureService( movieRepository: MovieRepository): MovieCaptureService {
        return MovieCaptureService( movieRepository)
    }



}