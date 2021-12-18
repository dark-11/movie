package com.example.base

import android.app.Activity
import android.os.Bundle
import androidx.annotation.CallSuper
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity : DaggerAppCompatActivity() {




    val mDisposables: CompositeDisposable = CompositeDisposable()

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

    }

    override fun onDestroy() {
        mDisposables.clear()
        super.onDestroy()
    }

}