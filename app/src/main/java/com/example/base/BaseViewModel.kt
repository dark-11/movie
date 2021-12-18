package com.example.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


abstract class BaseViewModel : ViewModel() {

    val mDisposables: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        mDisposables.clear()
        super.onCleared()
    }

    fun clear() = onCleared()
}