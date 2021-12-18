package com.example.base


import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import timber.log.BuildConfig
import timber.log.Timber
import javax.inject.Inject


open class BaseApplication : DaggerApplication() {

    @Inject lateinit var androidInjector : DispatchingAndroidInjector<Any>
    @Inject lateinit var debugTree: Timber.DebugTree


    override fun onCreate() {
        super.onCreate()


        init()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }

    private fun init() {
        initDependencyGraph()
        initFirebase()
        initTimber()


    }

    open fun initDependencyGraph() {
        DaggerApplicationComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }


    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(debugTree)
        }
    }


}