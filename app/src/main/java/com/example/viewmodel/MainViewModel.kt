package com.example.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableInt
import androidx.databinding.ObservableList
import com.example.base.BaseViewModel
import com.example.base.BaseViewModelDelegate
import com.example.delegates.MainViewModelDelegate
import com.example.model.MovieData
import com.example.model.MovieResponse
import com.example.movie.R
import com.example.service.Api
import com.example.service.ApiService
import com.example.service.MovieCaptureService
import com.example.utility.BottomSheet
import com.example.utility.Constant
import com.example.utility.Transformers
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.reactivex.Observable
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import retrofit2.HttpException
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class MainViewModel @Inject constructor(private val apiService: ApiService, private val movieCaptureService: MovieCaptureService) : BaseViewModel() {
    @Inject lateinit var bottomSheet: BottomSheet

    lateinit var delegate: MainViewModelDelegate

    var query = Api.makeApiCall(apiService, Constant.TOKEN)
 fun init()
 {
     makeApiCall(query)
 }

     fun onFabClick()
     {

       delegate.showBottomSheet()
     }
    var movieItemBinding = OnItemBindClass<Any>()
        .map(ManageMovieItemViewModel::class.java, BR.viewModel, R.layout.manage_movie_item)!!
    var movieItemList: ObservableList<Any> = ObservableArrayList()
    private var movieItems = ArrayList<ManageMovieItemViewModel>()
    val spinnerVisibility = ObservableInt(View.INVISIBLE)

    @SuppressLint("CheckResult")
    fun makeApiCall(query: Observable<MovieResponse>) {
        spinnerVisibility.set(View.VISIBLE)
        movieItemList.clear()
        movieItems.clear()
        query
            .compose(Transformers.apiRequestTransformer("MovieList"))

            .subscribe(
                { response ->
                    spinnerVisibility.set(View.GONE)
                    response.results.map {
                        val itemViewModel = ManageMovieItemViewModel()
                        itemViewModel.setValues(it)
                        movieItems.add(itemViewModel)
                        movieCaptureService.persistMovieCaptureData(movieData =  it as MovieData)

                    }

                    movieItemList.addAll(movieItems)


                },
                {
                    spinnerVisibility.set(View.GONE)
                    Log.e("Error", "" + it.printStackTrace())
                }
            )

    }
}