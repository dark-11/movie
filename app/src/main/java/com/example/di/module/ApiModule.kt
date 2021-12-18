package com.example.di.module


import com.example.service.ApiInterceptor
import com.example.service.ApiService
import com.example.utility.Constant
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideRxJavaCallAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    @Named("apiBuilder")
    fun provideApiRetrofitBuilder(
            rxJavaCallAdapterFactory: RxJava2CallAdapterFactory,
            gsonConverterFactory: GsonConverterFactory): Retrofit.Builder {
        return Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
    }







    @Provides
    @Singleton
    @Named("apiOkHttp")
    fun providesOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(15, TimeUnit.SECONDS)
        builder.readTimeout(15, TimeUnit.SECONDS)
//        if ("release" != BuildConfig.BUILD_TYPE) {
            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logInterceptor)
//        }
        return builder.build()
    }






    @Provides
    @Singleton
    fun provideStarcomApi(
            @Named("apiBuilder") retrofitBuilder: Retrofit.Builder,
            @Named("apiOkHttp") okHttpClient: OkHttpClient): ApiService {
        return retrofitBuilder
                .client(okHttpClient)
                .build()
                .create(ApiService::class.java)
    }





    @Provides
    @Singleton
    fun provideApiInterceptor(): ApiInterceptor {
        return ApiInterceptor()
    }


}