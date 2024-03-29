package com.shivesh.movie.di.module

import com.shivesh.movie.data.network.ItemTypeAdapterFactory
import com.shivesh.movie.data.network.MovieService
import com.shivesh.movie.di.scope.ApplicationScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import shiveshmehta.android.movie.BuildConfig

/**
 * Created by Shivesh K Mehta on 15-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

@Module
class RetrofitModule{

    @Provides
    @ApplicationScope
    fun provideTmdbService(retrofit: Retrofit): MovieService =
        retrofit.create(MovieService::class.java)

    @Provides
    @ApplicationScope
    fun provideRetrofit(httpClient: OkHttpClient, gson: Gson) : Retrofit =

        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    @Provides
    @ApplicationScope
    fun provideOkHttpCLient(interceptor: Interceptor) : OkHttpClient =
        OkHttpClient().newBuilder().addInterceptor(interceptor).build()

    @Provides
    @ApplicationScope
    fun provideGson() : Gson = GsonBuilder()
    .registerTypeAdapterFactory(ItemTypeAdapterFactory())
    .setDateFormat("yyyy-MM-dd HH:mm:ss")
    .create()

    @Provides
    @ApplicationScope
    fun provideInterceptor() : Interceptor =  Interceptor { chain ->
        val request = chain.request()
        val url = request.url().newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()
        val newRequest = request.newBuilder()
            .url(url)
            .build()
        chain.proceed(newRequest)
    }
}

