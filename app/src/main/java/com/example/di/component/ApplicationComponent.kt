package com.example.di.component



import com.example.base.BaseApplication
import com.example.di.module.ApiModule
import com.zeromotorcycles.nextgen.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ApiModule::class
))
interface ApplicationComponent : AndroidInjector<BaseApplication>{

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: BaseApplication): Builder
        fun build(): ApplicationComponent
    }

    override fun inject(app: BaseApplication)
}