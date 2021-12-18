package com.zeromotorcycles.nextgen.di.module


import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule(private val activity: Activity) {

    @Provides
    fun provideActivity(): Activity = activity

    @Provides
    fun provideActivityContext(): Context = activity.baseContext
}