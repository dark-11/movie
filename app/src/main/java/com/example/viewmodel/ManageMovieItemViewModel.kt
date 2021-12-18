package com.example.viewmodel

import com.example.base.BaseViewModel
import com.example.model.Results
import com.example.utility.ObservableString

class ManageMovieItemViewModel: BaseViewModel() {
    var base_path = ": https://image.tmdb.org/t/p/w500/"
    var movieImageView= ObservableString("")
    var movieNameLabel= ObservableString("")
    var moviePlayList = ObservableString("")


    fun setValues(movieData: Results) {
        movieImageView.set(base_path+movieData.poster_path)
        movieNameLabel.set(movieData.title)


    }


}
