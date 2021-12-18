package com.example.utility

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


object Transformers {

    fun <T> apiRequestTransformer(logLabel: String): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable
                .compose(logging(logLabel))
                .compose(threading())
        }
    }

    fun <T> logging(logLabel: String): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable
                .doOnNext { Timber.d("$logLabel: result: $it") }
                .doOnError { Timber.d("$logLabel: error: $it") }
        }
    }

    fun <T> threading(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
        }
    }
}